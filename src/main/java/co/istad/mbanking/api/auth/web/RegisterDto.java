package co.istad.mbanking.api.auth.web;

import co.istad.mbanking.constraint.email.EmailUnique;
import co.istad.mbanking.constraint.password.Password;
import co.istad.mbanking.constraint.password.PasswordMatch;
import co.istad.mbanking.constraint.role.RoleIdConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@PasswordMatch(password = "password",
        confirmedPassword = "confirmedPassword",
        message = "Your password is not match")
public record RegisterDto(
        @NotBlank(message = "Email is required!")
        @EmailUnique
        @Email
        String email,
        @NotBlank(message = "Password is required!")
        @Password
        String password,
        @NotBlank(message = "Confirmed password is required!")
        @Password
        String confirmedPassword,
        @NotNull(message = "Roles are required!")
        @RoleIdConstraint
        List<Integer> roleIds) {
}
