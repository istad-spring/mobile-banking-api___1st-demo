package co.istad.mbanking.exception;

import co.istad.mbanking.base.BaseError;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

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
}
