package co.istad.mbanking.security;

import co.istad.mbanking.api.user.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class CustomJwtConverter implements Converter<Jwt, UsernamePasswordAuthenticationToken> {
    @Override
    public UsernamePasswordAuthenticationToken convert(Jwt source) {
        User user = new User();
        user.setEmail(source.getSubject());
        return new UsernamePasswordAuthenticationToken(user, source, Collections.emptyList());
    }
}
