package oncall.view;

import java.util.List;
import oncall.model.WorkSchedule;

public class OutputView {

    private static final String NEXT_LINE = System.lineSeparator();

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printWorkSchedules(List<WorkSchedule> workSchedules) {
        StringBuilder sb = new StringBuilder();
        for (WorkSchedule workSchedule : workSchedules) {
            sb.append(workSchedule.getMonth()).append("월 ").append(workSchedule.getDate()).append("일 ")
                    .append(workSchedule.getDayOfweek()).append(" ").append(workSchedule.getWorker()).append(NEXT_LINE);
        }
        System.out.println(sb);
    }
}
