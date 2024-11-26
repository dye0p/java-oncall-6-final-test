package oncall.model;

import java.util.HashSet;
import java.util.List;
import oncall.exception.ErrorMessage;

public class WeekdayWorkers {

    private static final int MIN_WORKER_SIZE = 5;
    private static final int MAX_WORKER_SIZE = 35;

    private final List<Worker> weekdayWorkers;

    private WeekdayWorkers(List<Worker> weekdayWorkers) {
        validateDuplicate(weekdayWorkers);
        validateSize(weekdayWorkers);

        this.weekdayWorkers = weekdayWorkers;
    }

    public static WeekdayWorkers from(List<Worker> weekdayWorkers) {
        return new WeekdayWorkers(weekdayWorkers);
    }

    private void validateDuplicate(List<Worker> workers) {
        HashSet<Worker> nonDuplicateWorkers = new HashSet<>(workers);
        if (nonDuplicateWorkers.size() != workers.size()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }

    private void validateSize(List<Worker> workers) {
        if (workers.size() < MIN_WORKER_SIZE || workers.size() > MAX_WORKER_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }

    public void isContain(List<Worker> dayOffWorkers) {
        for (Worker dayOffWorker : dayOffWorkers) {
            if (!weekdayWorkers.contains(dayOffWorker)) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
            }
        }
    }

    public List<Worker> getWeekdayWorkers() {
        return weekdayWorkers;
    }

    int workerCount = 0;

    public Worker getWorker() {
        workerCount = workerCount % weekdayWorkers.size();
        return weekdayWorkers.get(workerCount++);
    }
}
