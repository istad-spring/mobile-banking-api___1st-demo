package co.istad.mbanking.api.account;

import co.istad.mbanking.api.accounttype.AccountType;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    private Integer id;
    private String accountNo;
    private String accountName;
    private String pin;
    private BigDecimal transferLimit;

    // Account has an account type (Saving, Credit, Visa, Mastercard, ...)
    private AccountType accountType;

}
