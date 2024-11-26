package oncall.model;

public class Workers {

    private final WeekdayWorkers weekdayWorkers;
    private final DayOffWorkers dayOffWorkers;

    private Workers(WeekdayWorkers weekdayWorkers, DayOffWorkers dayOffWorkers) {
        weekdayWorkers.isContain(dayOffWorkers.getDayOffWorkers());
        dayOffWorkers.isContain(weekdayWorkers.getWeekdayWorkers());

        this.weekdayWorkers = weekdayWorkers;
        this.dayOffWorkers = dayOffWorkers;
    }

    public static Workers of(WeekdayWorkers weekdayWorkers, DayOffWorkers dayOffWorkers) {
        return new Workers(weekdayWorkers, dayOffWorkers);
    }

    public Worker findWorkerByDayOfWeek(int month, int date, String dayOfTheWeek) {
        if (isPublicHoliday(month, date, dayOfTheWeek)) {
            return dayOffWorkers.getWorker();
        }
        return weekdayWorkers.getWorker();
    }

    private boolean isPublicHoliday(int month, int date, String dayOfTheWeek) {
        return DayOfTheWeek.isDayOff(dayOfTheWeek) || Holidays.isHoliday(month, date);
    }
}
