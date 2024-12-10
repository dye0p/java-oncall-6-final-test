package oncall.controller;

import java.util.function.Supplier;
import oncall.exception.ErrorMessage;
import oncall.model.Calender;
import oncall.model.DayOfWeek;
import oncall.model.Month;
import oncall.view.InputView;
import oncall.view.OutputView;

public class OnCallController {

    private final InputView inputView;
    private final OutputView outputView;

    public OnCallController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Calender calender = tryMontAndDate();

    }

    private Calender tryMontAndDate() {
        return requestRead(() -> {
            String[] monthAndDate = inputView.readMonthAndDayOfWeek();

            int inputMonth = parseMonth(monthAndDate);
            String inputDayOfWeek = monthAndDate[1];

            Month month = Month.of(inputMonth);
            DayOfWeek dateOfWeek = DayOfWeek.of(inputDayOfWeek);

            return Calender.of(month, dateOfWeek);
        });
    }

    private int parseMonth(String[] monthAndDate) {
        try {
            return Integer.parseInt(monthAndDate[0]);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getErrorMessage());
        }
    }

    private <T> T requestRead(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception.getMessage());
            }
        }
    }
}
