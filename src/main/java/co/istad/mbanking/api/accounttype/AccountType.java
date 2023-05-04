package co.istad.mbanking.api.accounttype;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@Setter
public class AccountType {
    private Integer id;
    private String name;
}
