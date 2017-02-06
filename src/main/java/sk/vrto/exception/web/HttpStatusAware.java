package sk.vrto.exception.web;

import org.springframework.http.HttpStatus;

public interface HttpStatusAware {
    HttpStatus getHttpStatus();
}
