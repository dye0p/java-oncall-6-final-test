package oncall.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.PatternSyntaxException;
import oncall.exception.ErrorMessage;

public class InputConverter {

    private static final String DELIMITER = ",";

    public static String[] convertMonthAndDayOfWeek(String monthAndDayOfWeek) {

        return validateSplit(monthAndDayOfWeek);
    }

    public static List<String> convertWorker(String inputWorkers) {
        String[] splitWorker = validateSplit(inputWorkers);
        return new ArrayList<>(Arrays.asList(splitWorker));
    }

    private static String[] validateSplit(String monthAndDayOfWeek) {
        try {
            return monthAndDayOfWeek.trim().split(DELIMITER);
        } catch (PatternSyntaxException exception) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getErrorMessage());
        }
    }

}
