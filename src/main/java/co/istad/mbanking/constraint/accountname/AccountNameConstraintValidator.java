package co.istad.mbanking.constraint.accountname;

import co.istad.mbanking.api.account.AccountMapper;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountNameConstraintValidator implements ConstraintValidator<ValidAccountName, String> {

    private final AccountMapper accountMapper;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !accountMapper.existsAccountName(value);
    }
}
