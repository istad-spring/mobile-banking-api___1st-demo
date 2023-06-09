package co.istad.mbanking.constraint.phonenumber;

import co.istad.mbanking.api.account.AccountMapper;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountPhoneNumberConstraintValidator implements ConstraintValidator<ValidAccountPhoneNumber, String> {

    private final AccountMapper accountMapper;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !accountMapper.existsAccountPhoneNumber(value);
    }
}
