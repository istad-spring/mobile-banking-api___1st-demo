package co.istad.mbanking.api.auth.web;

import java.util.Collection;
import java.util.List;

public record AuthDto(String email,
                      List<String> authorities,
                      String accessToken,
                      String refreshToken) {

}
