package oncall;

import oncall.controller.OnCallController;
import oncall.view.InputView;
import oncall.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        OnCallController onCallController = new OnCallController(inputView, outputView);

        onCallController.run();
    }
}
