package co.istad.mbanking.api.auth;

import co.istad.mbanking.api.auth.web.RegisterDto;

public interface AuthService {

    void register(RegisterDto registerDto);

    void verify(String email);

    void checkVerify(String email, String verifiedCode);

}
