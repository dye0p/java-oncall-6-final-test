package oncall.controller;

import oncall.model.Calender;
import oncall.model.Day;
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
        Calender calender = tryReadMonthAndDay();
    }

    private Calender tryReadMonthAndDay() {
        while (true) {
            try {
                String[] monthAndDay = inputView.readMonthAndDay();

                Month month = new Month(Integer.parseInt(monthAndDay[0]));
                Day day = new Day(monthAndDay[1]);

                return new Calender(month, day);
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception.getMessage());
            }
        }
    }
}
