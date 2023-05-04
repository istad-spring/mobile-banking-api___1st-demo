package co.istad.mbanking.api.accounttype;

import jakarta.validation.constraints.NotBlank;

public record AccountTypeDto(@NotBlank(message = "Account type name is required!")
                             String name) {
}
