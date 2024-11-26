package oncall.model;

import java.util.HashSet;
import java.util.List;
import oncall.exception.ErrorMessage;

public class WeekdayWorkers {

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
        if (workers.size() < 5 || workers.size() > 35) {
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
