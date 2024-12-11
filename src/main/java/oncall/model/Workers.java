package oncall.model;

public class Workers {

    private final WeekdayWorkers weekdayWorkers;
    private final WeekendWorkers weekendWorkers;

    public Workers(WeekdayWorkers weekdayWorkers, WeekendWorkers weekendWorkers) {
        this.weekdayWorkers = weekdayWorkers;
        this.weekendWorkers = weekendWorkers;
    }

    public Worker findWorkerBy(String dayOfWeek, int month, int date) {
        if (DayOfWeek.isWeekend(dayOfWeek) || HolyDay.isHolyDay(month, date)) {
            return weekendWorkers.findWorker();
        }
        return weekdayWorkers.findWorker();
    }
}
