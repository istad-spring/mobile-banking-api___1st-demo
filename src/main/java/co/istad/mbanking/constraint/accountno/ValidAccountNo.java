package co.istad.mbanking.constraint.accountno;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = AccountNoConstraintValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValidAccountNo {

    String message() default "Account no is already existed!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
