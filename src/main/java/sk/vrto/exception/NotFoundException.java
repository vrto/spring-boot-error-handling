package sk.vrto.exception;

public class NotFoundException extends AuthorizationException {
    public NotFoundException(String message) {
        super(message);
    }
}
