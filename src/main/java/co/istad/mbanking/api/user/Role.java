package co.istad.mbanking.api.user;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role implements GrantedAuthority {

    private Integer id;
    private String name;

    @Override
    public String getAuthority() {
        return "ROLE_" + name; // ROLE_CUSTOMER
    }
}
