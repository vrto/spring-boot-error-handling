package sk.vrto;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
@Slf4j
class ErrorHandler {

    @ExceptionHandler(Exception.class)
    ResponseEntity<JsonError> allOtherErrorsHandler(Exception exception) {
        log.error("Internal Server Error: ", exception);

        return new ResponseEntity<>(
                JsonError.internalServerError("Oops! Something went wrong!"),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    ResponseEntity<JsonError> unknownRouteHandler(WebRequest request) {
        return new ResponseEntity<>(
                JsonError.notFound("Unknown path: " + ((ServletRequestAttributes) request).getRequest().getRequestURI()),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    ResponseEntity<JsonError> invalidPayloadMarshallingHandler() {
        return new ResponseEntity<>(
                JsonError.badRequest("Failure parsing request body!"),
                HttpStatus.BAD_REQUEST);
    }
}
