package co.istad.mbanking.api.auth.web;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterDto(
        @NotBlank(message = "Email is required!")
        @Email
        String email,
        @NotBlank(message = "Password is required!")
        String password,
        @NotBlank(message = "Confirmed password is required!")
        String confirmedPassword) {
}
