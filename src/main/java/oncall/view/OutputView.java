package oncall.view;

import java.util.List;
import oncall.model.ScheduleResult;

public class OutputView {

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printScheduleResult(List<ScheduleResult> scheduleResults) {
        String scheduleResultFormat = OutputFormatter.formatScheduleResult(scheduleResults);
        System.out.println(scheduleResultFormat);
    }
}
