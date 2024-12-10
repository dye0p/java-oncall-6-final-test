package oncall.model;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import oncall.exception.ErrorMessage;

public class Workers {

    private final Deque<Worker> workers;

    private Workers(Deque<Worker> workers) {
        validateDuplicate(workers);
        validateSize(workers);
        this.workers = workers;
    }

    public static Workers of(Deque<Worker> workers) {
        return new Workers(workers);
    }

    private void validateSize(Deque<Worker> workers) {
        if (workers.size() > 35 || workers.size() < 5) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getErrorMessage());
        }
    }

    private void validateDuplicate(Deque<Worker> workers) {
        HashSet<Worker> nonDuplicateWorkerSet = new HashSet<>(workers);
        if (nonDuplicateWorkerSet.size() != workers.size()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getErrorMessage());
        }
    }

    public Deque<Worker> getWorkers() {
        return new ArrayDeque<>(this.workers);
    }
}
