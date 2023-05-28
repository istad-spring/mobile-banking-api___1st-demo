package co.istad.mbanking.security;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.oauth2.server.resource.authentication.BearerTokenAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class JwtFailureEvents {

    private HttpServletResponse response;

    @Autowired
    public void setHttpServletResponse(HttpServletResponse httpServletResponse) {
        this.response = httpServletResponse;
    }

    @EventListener
    public void onFailure(AuthenticationFailureBadCredentialsEvent badCredentials) {
        if (badCredentials.getAuthentication() instanceof BearerTokenAuthenticationToken) {
            System.out.println(badCredentials.getException().getMessage());
        }
    }

}
