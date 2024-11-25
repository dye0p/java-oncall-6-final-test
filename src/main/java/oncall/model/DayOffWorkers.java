package oncall.model;

import java.util.HashSet;
import java.util.List;
import oncall.exception.ErrorMessage;

public class DayOffWorkers {

    private final List<Worker> dayOffWorkers;

    public DayOffWorkers(List<Worker> dayOffWorkers) {
        validateDuplicate(dayOffWorkers);
        validateSize(dayOffWorkers);

        this.dayOffWorkers = dayOffWorkers;
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

    //근무자 리턴
    int workerCount = 0;

    public String getWorker() {
        workerCount = workerCount % dayOffWorkers.size();
        Worker worker = dayOffWorkers.get(workerCount);
        workerCount++;
        return worker.getName();
    }
}
