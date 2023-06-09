package co.istad.mbanking.constraint.phonenumber;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = AccountPhoneNumberConstraintValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValidAccountPhoneNumber {

    String message() default "Account phone number is already existed!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
