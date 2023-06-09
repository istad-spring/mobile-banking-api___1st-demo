package co.istad.mbanking.constraint.accounttype;

import co.istad.mbanking.api.accounttype.AccountTypeMapper;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountTypeConstraintValidator implements ConstraintValidator<ValidAccountType, Integer> {

    private final AccountTypeMapper accountTypeMapper;

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return accountTypeMapper.selectById(value).isPresent();
    }
}
