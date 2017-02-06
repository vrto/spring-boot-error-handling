package sk.vrto.exception.web;

public abstract class AuthorizationException extends RuntimeException implements HttpStatusAware {
    public AuthorizationException(String message) {
        super(message);
    }
}
