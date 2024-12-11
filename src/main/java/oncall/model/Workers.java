package oncall.model;

public class Workers {

    private final WeekdayWorkers weekdayWorkers;
    private final WeekendWorkers weekendWorkers;

    public Workers(WeekdayWorkers weekdayWorkers, WeekendWorkers weekendWorkers) {
        this.weekdayWorkers = weekdayWorkers;
        this.weekendWorkers = weekendWorkers;
    }

    public Worker findWorkerBy(String dayOfWeek, int month, int date) {
        if (isWeekendAndHolyDay(dayOfWeek, month, date)) {
            return weekendWorkers.findWorker();
        }
        return weekdayWorkers.findWorker();
    }

    private boolean isWeekendAndHolyDay(String dayOfWeek, int month, int date) {
        return DayOfWeek.isWeekend(dayOfWeek) || HolyDay.isHolyDay(month, date);
    }
}
