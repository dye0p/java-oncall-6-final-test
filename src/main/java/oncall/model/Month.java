package oncall.model;

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
}
