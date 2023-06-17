package co.istad.mbanking.api.auth.web;

public record LoggedInProfileDto(String name,
                                 String gender,
                                 String studentCardId,
                                 Boolean isStudent) {
}
