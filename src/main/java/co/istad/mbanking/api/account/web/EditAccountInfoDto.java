package co.istad.mbanking.api.account.web;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record EditAccountInfoDto(@NotBlank String pin,
                                 @NotBlank String profile,
                                 @NotNull BigDecimal transferLimit) {
}
