package co.istad.mbanking.constraint.role;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = RoleIdConstraintValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface RoleIdConstraint {

    String message() default "Role ID is not existed!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
