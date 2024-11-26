package oncall.model;

import java.util.HashSet;
import java.util.List;
import oncall.exception.ErrorMessage;

public class DayOffWorkers {

    private final List<Worker> dayOffWorkers;

    private DayOffWorkers(List<Worker> dayOffWorkers) {
        validateDuplicate(dayOffWorkers);
        validateSize(dayOffWorkers);

        this.dayOffWorkers = dayOffWorkers;
    }

    public static DayOffWorkers from(List<Worker> dayOffWorkers) {
        return new DayOffWorkers(dayOffWorkers);
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

    public void isContain(List<Worker> weekdayWorkers) {
        for (Worker weekdayWorker : weekdayWorkers) {
            if (!dayOffWorkers.contains(weekdayWorker)) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
            }
        }
    }

    public List<Worker> getDayOffWorkers() {
        return dayOffWorkers;
    }

    int workerCount = 0;

    public Worker getWorker() {
        workerCount = workerCount % dayOffWorkers.size();
        return dayOffWorkers.get(workerCount++);
    }
}
