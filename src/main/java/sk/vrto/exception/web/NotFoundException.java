package sk.vrto.exception.web;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import sk.vrto.JsonError;

public class NotFoundException extends AuthorizationException {

    @Getter
    private HttpStatus httpStatus = HttpStatus.NOT_FOUND;

    public NotFoundException(String message) {
        super(message);
    }

    @Override
    public JsonError createErrorBody() {
        return JsonError.notFound(getMessage());
    }
}
