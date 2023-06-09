package co.istad.mbanking.constraint.accountno;

import co.istad.mbanking.api.account.AccountMapper;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountNoConstraintValidator implements ConstraintValidator<ValidAccountNo, String> {

    private final AccountMapper accountMapper;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !accountMapper.existsAccountNo(value);
    }
}
