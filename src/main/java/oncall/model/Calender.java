package oncall.model;

import java.time.LocalDate;
import java.time.YearMonth;
import oncall.exception.ErrorMessage;

public class Calender {

    private final Month month;
    private final DayOfTheWeek day;

    public Calender(Month month, DayOfTheWeek day) {
        validateDay(month, day);
        this.month = month;
        this.day = day;
    }

    public static Calender of(int month, String day) {
        return new Calender(new Month(month), DayOfTheWeek.of(day));
    }

    public String isHolidayAndWeekday(String dayOfWeek, int month, int date) {
        if (DayOfTheWeek.isWeekday(dayOfWeek) && Holidays.isHoliday(month, date)) {
            dayOfWeek = dayOfWeek + "(휴일)";
        }
        return dayOfWeek;
    }

    public int getScheduleMonth() {
        return month.getEndDate().atEndOfMonth().lengthOfMonth();
    }

    public int getMonth() {
        return month.getMonth();
    }

    public String getDayOfTheWeekByDate(int date) {
        return month.getDayOfTheWeek(date);
    }

    private void validateDay(Month month, DayOfTheWeek day) {
        YearMonth yearMonth = YearMonth.of(2023, month.getMonth());
        LocalDate localDate = yearMonth.atDay(1);
        int firstDayOfWeek = localDate.getDayOfWeek().getValue();

        if (day.getValue() != firstDayOfWeek) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }
}
