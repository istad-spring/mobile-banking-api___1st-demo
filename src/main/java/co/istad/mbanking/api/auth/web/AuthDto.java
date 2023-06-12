package co.istad.mbanking.api.auth.web;

public record AuthDto(String tokenType,
                      String accessToken,
                      String refreshToken) {
}
