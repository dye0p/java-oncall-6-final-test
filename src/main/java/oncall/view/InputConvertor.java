package oncall.view;

import java.util.ArrayList;
import java.util.List;
import oncall.exception.ErrorMessage;
import oncall.model.Worker;

public class InputConvertor {

    private static final String MONTH_AND_DAY_DELIMITER = ",";

    public static String[] convertMonthAndDay(String input) {
        validate(input);
        String[] monthAndDay = inputSplit(input);
        validateSize(monthAndDay);
        return monthAndDay;
    }

    public static List<Worker> convertWorkers(String input) {
        validate(input);
        String[] splitWorkers = inputSplit(input);

        List<Worker> workers = new ArrayList<>();

        for (String splitWorker : splitWorkers) {
            workers.add(new Worker(splitWorker));
        }

        return workers;
    }

    private static void validate(String input) {
        if (input.isEmpty() || input.contains(" ")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }

    private static String[] inputSplit(String input) {
        try {
            return input.trim().split(MONTH_AND_DAY_DELIMITER);
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
