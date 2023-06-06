package co.istad.mbanking.exception;

import co.istad.mbanking.base.BaseError;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.server.resource.InvalidBearerTokenException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class SecurityException {

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AuthenticationException.class)
    public BaseError<?> handleServiceException(AuthenticationException e) {
        return BaseError.builder()
                .status(false)
                .code(HttpStatus.UNAUTHORIZED.value())
                .timestamp(LocalDateTime.now())
                .message("Something went wrong..!, please check.")
                .errors(e.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(InvalidBearerTokenException.class)
    public BaseError<?> handleInvalidBearerTokenException(InvalidBearerTokenException e) {
        return BaseError.builder()
                .status(false)
                .code(HttpStatus.UNAUTHORIZED.value())
                .timestamp(LocalDateTime.now())
                .message("Something went wrong..!, please check.")
                .errors(e.getMessage())
                .build();
    }
}
