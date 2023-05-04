package co.istad.mbanking.api.user.web;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateUserDto(@NotBlank(message = "Name is required!") String name,
                            @NotBlank(message = "Gender is required!")  String gender,
                            String oneSignalId,
                            String studentCardId,
                            @NotNull(message = "You have to confirm, are you a student?")  Boolean isStudent) {
}
