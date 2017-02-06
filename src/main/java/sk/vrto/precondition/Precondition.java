package sk.vrto.precondition;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import sk.vrto.JsonError;

import java.util.Optional;

public interface Precondition<T> {

    Optional<ResponseEntity<T>> verify();

    class SamplePassingPrecondition implements Precondition<JsonError> {
        @Override
        public Optional<ResponseEntity<JsonError>> verify() {
            // no error!
            return Optional.empty();
        }
    }

    class SampleFailingPrecondition implements Precondition<JsonError> {
        @Override
        public Optional<ResponseEntity<JsonError>> verify() {
            return Optional.of(new ResponseEntity<>(
                    JsonError.notFound("Precondition failed, because something was not found."),
                    HttpStatus.NOT_FOUND));
        }
    }

}
