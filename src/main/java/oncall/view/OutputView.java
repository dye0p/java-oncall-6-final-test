package oncall.view;

import java.util.List;
import oncall.model.dto.WorkScheduleDto;

public class OutputView {

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printWorkSchedules(List<WorkScheduleDto> workSchedules) {
        String scheduleResult = OutputFormatter.formatScheduleResult(workSchedules);
        System.out.println(scheduleResult);
    }
}
