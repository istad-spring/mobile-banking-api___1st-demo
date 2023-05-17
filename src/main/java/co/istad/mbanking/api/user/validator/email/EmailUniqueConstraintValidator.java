package co.istad.mbanking.api.user.validator.email;

import co.istad.mbanking.api.user.UserMapper;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmailUniqueConstraintValidator
        implements ConstraintValidator<EmailUnique, String> {

    private final UserMapper userMapper;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return !userMapper.existsByEmail(email);
    }
}
