package co.istad.mbanking.api.auth.web;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record RegisterDto(@NotBlank
                          String email,
                          @NotBlank
                          String password,
                          @NotBlank
                          String confirmedPassword) {
}
