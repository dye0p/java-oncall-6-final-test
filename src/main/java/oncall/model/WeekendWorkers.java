package oncall.model;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import oncall.exception.ErrorMessage;

public class WeekendWorkers {

    private static final int MAX_WORKER_SIZE = 35;
    private static final int MIN_WORKER_SIZE = 5;

    private final Deque<Worker> workers;

    private WeekendWorkers(Deque<Worker> workers) {
        validateDuplicate(workers);
        validateSize(workers);
        this.workers = workers;
    }

    public static WeekendWorkers of(Deque<Worker> workers) {
        return new WeekendWorkers(workers);
    }

    public Worker findWorker() {
        Worker worker = workers.pop();
        workers.addLast(worker);

        return worker;
    }

    private void validateSize(Deque<Worker> workers) {
        if (workers.size() > MAX_WORKER_SIZE || workers.size() < MIN_WORKER_SIZE) {
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
