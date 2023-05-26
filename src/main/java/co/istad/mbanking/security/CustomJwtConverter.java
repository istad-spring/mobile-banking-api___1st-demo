package co.istad.mbanking.security;

import co.istad.mbanking.api.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
@Slf4j
public class CustomJwtConverter implements Converter<Jwt, UsernamePasswordAuthenticationToken> {
    @Override
    public UsernamePasswordAuthenticationToken convert(Jwt source) {

        log.info("JWT: {}", source.getId());

        User user = new User();
        user.setEmail(source.getSubject());

        List<SimpleGrantedAuthority> authorities = List.of(
                new SimpleGrantedAuthority("user")
        );

        log.info("JWT subject: {}", source.getSubject());
        log.info("JWT authorities: {}", source.getClaims());
        log.info("JWT authorities: {}", user.getRoles());

        return new UsernamePasswordAuthenticationToken(source.getId(),
                source.getTokenValue(),
                authorities);
    }
}
