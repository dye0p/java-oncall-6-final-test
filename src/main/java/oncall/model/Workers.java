package oncall.model;

public class Workers {

    private final WeekdayWorkers weekdayWorkers;
    private final DayOffWorkers dayOffWorkers;

    public Workers(WeekdayWorkers weekdayWorkers, DayOffWorkers dayOffWorkers) {
        weekdayWorkers.isContain(dayOffWorkers.getDayOffWorkers());
        dayOffWorkers.isContain(weekdayWorkers.getWeekdayWorkers());

        this.weekdayWorkers = weekdayWorkers;
        this.dayOffWorkers = dayOffWorkers;
    }
}
