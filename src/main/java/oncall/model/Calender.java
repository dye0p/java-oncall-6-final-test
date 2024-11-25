package oncall.model;

import java.time.DayOfWeek;
import java.time.YearMonth;

public class Calender {

    private final Month month;
    private final Day day;

    public Calender(Month month, Day day) {
        this.month = month;
        this.day = day;
    }

    public YearMonth getScheduleMonth() {
        return month.getEndDate();
    }

    public int getMonth() {
        return month.getMonth();
    }

    public DayOfWeek getDayOfTheWeekByDate(int date) {
        return month.getDayOfTheWeek(date);
    }
}
