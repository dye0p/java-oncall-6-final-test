package oncall.model;

public class ScheduleResult {

    private final int month;
    private final int date;
    private final String dayOfWeek;
    private final String worker;

    private ScheduleResult(int month, int date, String dayOfWeek, String worker) {
        if (DayOfWeek.isWeekday(dayOfWeek) && HolyDay.isHolyDay(month, date)) {
            dayOfWeek += "(휴일)";
        }
        this.month = month;
        this.date = date;
        this.dayOfWeek = dayOfWeek;
        this.worker = worker;
    }

    public static ScheduleResult of(int month, int date, String dayOfWeek, String worker) {
        return new ScheduleResult(month, date, dayOfWeek, worker);
    }

    public int getMonth() {
        return month;
    }

    public int getDate() {
        return date;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public String getWorker() {
        return worker;
    }
}
