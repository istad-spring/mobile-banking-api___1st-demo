package co.istad.mbanking.api.user.web;

public record UserDto(String name,
                      String gender,
                      String studentCardId,
                      Boolean isStudent) {
}
