package sk.vrto.exception.web;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class ConflictException extends AuthorizationException {

    @Getter
    private HttpStatus httpStatus = HttpStatus.CONFLICT;

    public ConflictException(String message) {
        super(message);
    }
}
