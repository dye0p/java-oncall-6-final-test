package oncall.view;

import oncall.exception.ErrorMessage;

public class InputConvertor {

    public static String[] convertMonthAndDay(String input) {
        validate(input);
        String[] monthAndDay = inputSplit(input);
        validateSize(monthAndDay);
        return monthAndDay;
    }

    private static void validate(String input) {
        if (input.isEmpty() || input.contains(" ")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }

    private static String[] inputSplit(String input) {
        try {
            return input.trim().split(",");
        } catch (Exception exception) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }

    private static void validateSize(String[] split) {
        if (split.length != 2) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }
}
