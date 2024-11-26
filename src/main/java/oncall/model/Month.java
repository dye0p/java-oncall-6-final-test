package oncall.model;

import java.time.LocalDate;
import java.time.YearMonth;
import oncall.exception.ErrorMessage;

public class Month {

    private final int month;

    public Month(int month) {
        validate(month);
        this.month = month;
    }

    private void validate(int month) {
        if (month > 12 || month < 1) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }

    public int getMonth() {
        return month;
    }

    public YearMonth getEndDate() {
        return YearMonth.of(2023, month);
    }

    public String getDayOfTheWeek(int date) {
        LocalDate localDate = LocalDate.of(2023, month, date);
        return DayOfTheWeek.getDayOfWeek(localDate.getDayOfWeek());
    }
}
