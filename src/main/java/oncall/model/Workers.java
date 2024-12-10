package oncall.model;

public class Workers {

    private final WeekdayWorkers weekdayWorkers;
    private final WeekendWorkers weekendWorkers;

    public Workers(WeekdayWorkers weekdayWorkers, WeekendWorkers weekendWorkers) {
        this.weekdayWorkers = weekdayWorkers;
        this.weekendWorkers = weekendWorkers;
    }
}
