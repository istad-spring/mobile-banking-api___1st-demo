package co.istad.mbanking.api.auth;

import co.istad.mbanking.api.auth.web.RegisterDto;
import co.istad.mbanking.api.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final AuthMapper authMapper;
    private final AuthMapStruct authMapStruct;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void register(RegisterDto registerDto) {

        User user = authMapStruct.fromRegisterDto(registerDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setIsVerified(false);
        user.setVerifiedCode(UUID.randomUUID().toString());
        user.setIsDeleted(false);
        log.info("User: {}", user.getEmail());

        try {
            authMapper.register(user);
        } catch (Exception e) {
            log.error(e.getCause().getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Register into server is failed..!");
        }
    }

}
