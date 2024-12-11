package oncall.model;

public class Calender {

    private final Month month;
    private DayOfWeek dayOfWeek;

    public Calender(Month month, DayOfWeek dayOfWeek) {
        this.month = month;
        this.dayOfWeek = dayOfWeek;
    }

    public static Calender of(Month month, DayOfWeek dayOfWeek) {
        return new Calender(month, dayOfWeek);
    }

    public int getMonthLength() {
        return Month.getMonthLength(month);
    }

    public String getDayOfWeek(int dayOfWeekCount) {
        return DayOfWeek.getValue(dayOfWeekCount);
    }

    public DayOfWeek getStartDayOfWeek() {
        return dayOfWeek;
    }

    public int getMonth() {
        return month.getMonth();
    }
}
