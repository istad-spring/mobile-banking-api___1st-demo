package co.istad.mbanking.api.auth.web;

import co.istad.mbanking.api.auth.AuthService;
import co.istad.mbanking.api.user.User;
import co.istad.mbanking.api.user.UserService;
import co.istad.mbanking.api.user.web.UserDto;
import co.istad.mbanking.base.BaseRest;
import co.istad.mbanking.security.CustomUserDetails;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthRestController {

    private final AuthService authService;
    private final UserService userService;

    @GetMapping("/me")
    public BaseRest<?> getAuthProfile(Authentication authentication) {

        log.info("Auth Name: {}", authentication.getPrincipal());
        log.info("Auth Credentials: {}", authentication.getCredentials());
        log.info("Auth Authorities: {}", authentication.getAuthorities());
        log.info("Auth Details: {}", authentication.getDetails());

        LoggedInProfileDto loggedInProfileDto = authService.getProfile(authentication);

        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("You have retrieved profile successfully")
                .timestamp(LocalDateTime.now())
                .data(loggedInProfileDto)
                .build();
    }

    @PostMapping("/token")
    public BaseRest<?> refreshToken(@RequestBody RefreshTokenDto tokenDto) {
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Token has been refreshed successfully")
                .timestamp(LocalDateTime.now())
                .data(authService.refreshToken(tokenDto))
                .build();
    }

    @PostMapping("/login")
    public BaseRest<?> login(@Valid @RequestBody LogInDto logInDto) {
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("You have been logged in successfully")
                .timestamp(LocalDateTime.now())
                .data(authService.login(logInDto))
                .build();
    }

    @PostMapping("/register")
    public BaseRest<?> register(@Valid @RequestBody RegisterDto registerDto) {

        // call service
        authService.register(registerDto);

        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("You have been registered successfully")
                .timestamp(LocalDateTime.now())
                .data(registerDto.email())
                .build();
    }

    @PostMapping("/verify")
    public BaseRest<?> verify(@RequestParam String email) {
        authService.verify(email);
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Please check email and verify")
                .timestamp(LocalDateTime.now())
                .data(email)
                .build();
    }

    @GetMapping("/check-verify")
    public BaseRest<?> checkVerify(@RequestParam String email,
                                   @RequestParam String verifiedCode) {

        log.info("Email: {}", email);
        log.info("Verified Code: {}", verifiedCode);

        authService.checkVerify(email, verifiedCode);

        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("You have been verified successfully")
                .timestamp(LocalDateTime.now())
                .data(email)
                .build();
    }

}
