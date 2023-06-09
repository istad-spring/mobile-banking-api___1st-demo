package co.istad.mbanking.api.account.web;

import co.istad.mbanking.constraint.accountname.ValidAccountName;
import co.istad.mbanking.constraint.accountno.ValidAccountNo;
import co.istad.mbanking.constraint.phonenumber.ValidAccountPhoneNumber;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NewAccountDto(@ValidAccountNo
                            @NotBlank String accountNo,
                            @ValidAccountName
                            @NotBlank String accountName,
                            String profile,
                            @NotBlank String pin,
                            @ValidAccountPhoneNumber
                            @NotBlank String phoneNumber,
                            @NotNull Integer accountTypeId,
                            @NotNull Integer userId) {
}
