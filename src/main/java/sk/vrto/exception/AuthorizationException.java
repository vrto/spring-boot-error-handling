package sk.vrto.exception;

public abstract class AuthorizationException extends RuntimeException {
    public AuthorizationException(String message) {
        super(message);
    }
}
