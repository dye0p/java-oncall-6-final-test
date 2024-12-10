package oncall.model;

public class Calender {

    private final Month month;
    private final DayOfWeek dayOfWeek;

    public Calender(Month month, DayOfWeek dayOfWeek) {
        this.month = month;
        this.dayOfWeek = dayOfWeek;
    }

    public static Calender of(Month month, DayOfWeek dayOfWeek) {
        return new Calender(month, dayOfWeek);
    }
}
