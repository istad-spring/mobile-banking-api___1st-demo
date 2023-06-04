package co.istad.mbanking.security;

import co.istad.mbanking.util.KeyUtil;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.KeySourceException;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSelector;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.oauth2.server.resource.web.BearerTokenAuthenticationEntryPoint;
import org.springframework.security.oauth2.server.resource.web.access.BearerTokenAccessDeniedHandler;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.util.List;
import java.util.UUID;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
    private final CustomAccessDeniedHandler customAccessDeniedHandler;
    private final CustomAuthenticationFailureHandler customAuthenticationFailureHandler;
    private final CustomJwtConverter customJwtConverter;
    private final KeyUtil keyUtil;

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {

        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userDetailsService);
        auth.setPasswordEncoder(passwordEncoder);

        return auth;
    }

    @Bean
    @Qualifier("jwtRefreshTokenAuthProvider")
    public JwtAuthenticationProvider jwtAuthenticationProvider() throws NoSuchAlgorithmException, JOSEException {

        JwtAuthenticationProvider provider = new JwtAuthenticationProvider(jwtRefreshTokenDecoder());
        provider.setJwtAuthenticationConverter(jwtAuthenticationConverter());

        return provider;
    }

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {

        JwtGrantedAuthoritiesConverter grantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
        grantedAuthoritiesConverter.setAuthoritiesClaimName("scope");

        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(grantedAuthoritiesConverter);

        return jwtAuthenticationConverter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // Disable CSRF
        http.csrf(AbstractHttpConfigurer::disable);

        // Authorize URL mapping
        http.authorizeHttpRequests(auth -> {
            auth.requestMatchers("/api/v1/auth/**").permitAll();
            auth.requestMatchers("/api/v1/users/**").hasAuthority("SCOPE_user");
            auth.anyRequest().authenticated();
        });

        // Security mechanism
        http.httpBasic().disable();
        http.oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter())));

        // Make security http STATELESS
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Exception handling:
        http.exceptionHandling(ex -> ex
                .authenticationEntryPoint(customAuthenticationEntryPoint)
                .accessDeniedHandler(customAccessDeniedHandler)
        );

        return http.build();
    }


    // ================================ Start Access Token ================================ //

    /*@Bean
    @Primary
    public KeyPair accessTokenKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        return keyPairGenerator.generateKeyPair();
    }*/

    /*@Bean
    @Primary
    public RSAKey accessTokenRSAKey(KeyPair keyPair) {
        return new RSAKey.Builder((RSAPublicKey) keyPair.getPublic())
                .privateKey(keyPair.getPrivate())
                .keyID(UUID.randomUUID().toString())
                .build();
    }*/

    @Bean
    @Primary
    public JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withPublicKey(keyUtil.getAccessTokenPublicKey()).build();
    }

    /*@Bean
    @Primary
    public JWKSource<SecurityContext> jwkSource() {
        JWKSet jwkSet = new JWKSet(jwk);
        return (jwkSelector, context) -> jwkSelector.select(jwkSet);
    }*/

    @Bean
    @Primary
    public JwtEncoder jwtEncoder() {

        JWK jwk = new RSAKey.Builder(keyUtil.getAccessTokenPublicKey())
                .privateKey(keyUtil.getAccessTokenPrivateKey())
                .build();

        return new NimbusJwtEncoder((jwkSelector, context)
                -> jwkSelector.select(new JWKSet(jwk)));
    }

    // ================================ End Access Token ================================ //


    // ================================ Start Refresh Token ================================ //
    /*@Bean
    @Qualifier("refreshTokenKeyPair")
    public KeyPair refreshTokenKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        return keyPairGenerator.generateKeyPair();
    }*/

    /*@Bean
    @Qualifier("refreshTokenRSAKey")
    public RSAKey refreshTokenRSAKey(@Qualifier("refreshTokenKeyPair") KeyPair keyPair) {
        return new RSAKey.Builder((RSAPublicKey) keyPair.getPublic())
                .privateKey(keyPair.getPrivate())
                .keyID(UUID.randomUUID().toString())
                .build();
    }*/

    @Bean
    @Qualifier("jwtRefreshTokenDecoder")
    public JwtDecoder jwtRefreshTokenDecoder() {
        return NimbusJwtDecoder.withPublicKey(keyUtil.getRefreshTokenPublicKey()).build();
    }

    /*@Bean
    @Qualifier("jwtSourceRefreshToken")
    public JWKSource<SecurityContext> jwkSourceRefreshToken(@Qualifier("refreshTokenRSAKey") RSAKey rsaKey) {
        JWKSet jwkSet = new JWKSet(rsaKey);
        return (jwkSelector, context) -> jwkSelector.select(jwkSet);
    }*/

    @Bean
    @Qualifier("jwtRefreshTokenEncoder")
    public JwtEncoder jwtRefreshTokenEncoder() {

        JWK jwk = new RSAKey.Builder(keyUtil.getRefreshTokenPublicKey())
                .privateKey(keyUtil.getRefreshTokenPrivateKey())
                .build();

        return new NimbusJwtEncoder((jwkSelector, context)
                -> jwkSelector.select(new JWKSet(jwk)));
    }

    // ================================ End Refresh Token ================================ //

}
