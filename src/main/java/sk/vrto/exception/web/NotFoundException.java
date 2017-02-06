package sk.vrto.exception.web;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class NotFoundException extends AuthorizationException {

    @Getter
    private HttpStatus httpStatus = HttpStatus.NOT_FOUND;

    public NotFoundException(String message) {
        super(message);
    }
}
