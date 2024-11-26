package oncall.model;

import oncall.exception.ErrorMessage;

public class Day {

    private final String day;

    public Day(String day) {
        validate(day);
        this.day = day;
    }

    private void validate(String day) {
        if (!DayOfTheWeek.isDayOfTheWeek(day)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }
}
