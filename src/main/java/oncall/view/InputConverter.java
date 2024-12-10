package oncall.view;

import java.util.regex.PatternSyntaxException;
import oncall.exception.ErrorMessage;

public class InputConverter {

    public static String[] convertMonthAndDayOfWeek(String monthAndDayOfWeek) {

        return splitMonthAndDayOfWeek(monthAndDayOfWeek);
    }

    private static String[] splitMonthAndDayOfWeek(String monthAndDayOfWeek) {
        try {
            return monthAndDayOfWeek.trim().split(",");
        } catch (PatternSyntaxException exception) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getErrorMessage());
        }
    }
}
