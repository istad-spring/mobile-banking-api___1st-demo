package co.istad.mbanking.api.auth;

import co.istad.mbanking.api.auth.web.*;
import co.istad.mbanking.api.user.web.UserDto;
import org.springframework.security.core.Authentication;

public interface AuthService {

    TokenDto refreshToken(RefreshTokenDto tokenDto);

    AuthDto login(LogInDto logInDto);

    void register(RegisterDto registerDto);

    void verify(String email);

    void checkVerify(String email, String verifiedCode);

    LoggedInProfileDto getProfile(Authentication authentication);

}
