package sk.vrto.precondition;

import lombok.val;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class PreconditionsAction {

    private List<Precondition<?>> currentPreconditions = new ArrayList<>();
    private Supplier<ResponseEntity<?>> resultSupplier;

    public PreconditionsAction addPrecondition(Precondition<?> precondition) {
        currentPreconditions.add(precondition);
        return this;
    }

    public PreconditionsAction whenAllPreconditionsMatch(Supplier<ResponseEntity<?>> resultSupplier) {
        this.resultSupplier = resultSupplier;
        return this;
    }

    public ResponseEntity<?> call() {
        val firstFailure = verifyAll();
        return firstFailure.orElseGet(resultSupplier);
    }

    private Optional<ResponseEntity> verifyAll() {
        return currentPreconditions.stream()
                .map(Precondition::verify)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(result -> (ResponseEntity) result) // response entity of anything, doesn't matter
                .findFirst();
    }

}
