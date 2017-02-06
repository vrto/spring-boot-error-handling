package sk.vrto.exception.web;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import sk.vrto.JsonError;

public class ConflictException extends AuthorizationException {

    @Getter
    private HttpStatus httpStatus = HttpStatus.CONFLICT;

    public ConflictException(String message) {
        super(message);
    }

    @Override
    public JsonError createErrorBody() {
        return JsonError.conflict(getMessage());
    }
}
