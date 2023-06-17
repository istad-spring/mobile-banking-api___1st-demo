package co.istad.mbanking.api.auth.web;

public record TokenDto(String accessToken, String refreshToken) {
}
