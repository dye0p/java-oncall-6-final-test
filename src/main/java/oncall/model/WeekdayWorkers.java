package oncall.model;

import java.util.HashSet;
import java.util.List;
import oncall.exception.ErrorMessage;

public class WeekdayWorkers {

    private final List<Worker> weekdayWorkers;

    public WeekdayWorkers(List<Worker> weekdayWorkers) {
        validateDuplicate(weekdayWorkers);
        validateSize(weekdayWorkers);

        this.weekdayWorkers = weekdayWorkers;
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
            //평일 근무자 순번에 주말 근무자가 들어 있는지?
            if (!weekdayWorkers.contains(dayOffWorker)) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
            }
        }
    }

    public List<Worker> getWeekdayWorkers() {
        return weekdayWorkers;
    }

    //근무자 리턴
    int workerCount = 0;

    public String getWorker() {
        workerCount = workerCount % weekdayWorkers.size();

        Worker worker = weekdayWorkers.get(workerCount);
        workerCount++;
        return worker.getName();
    }
}
