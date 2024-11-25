package oncall.model;

import oncall.exception.ErrorMessage;

public class Day {

    private final String day;

    public Day(String day) {
        validate(day);
        this.day = day;
    }

    private void validate(String day) {
        if (!day.equals("일") && !day.equals("월") && !day.equals("화") && !day.equals("수") && !day.equals("목")
                && !day.equals("금") && !day.equals("토")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }
}
