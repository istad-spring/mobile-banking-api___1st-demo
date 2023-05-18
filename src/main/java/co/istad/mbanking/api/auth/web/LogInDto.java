package co.istad.mbanking.api.auth.web;

import co.istad.mbanking.api.user.validator.password.Password;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LogInDto(@Email
                       @NotBlank String email,
                       @NotBlank
                       @Password String password) {
}
