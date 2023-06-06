package co.istad.mbanking.api.user;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role implements GrantedAuthority {

    private Integer id;
    private String name;
    private Set<Authority> authorities;

    @Override
    public String getAuthority() {
        // ROLE_CUSTOMER
        return "ROLE_" + name;
    }
}
