package co.istad.mbanking.api.auth;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {
    private Integer id;
    private String name;
}
