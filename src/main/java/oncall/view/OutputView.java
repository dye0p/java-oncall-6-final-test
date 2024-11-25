package oncall.view;

import oncall.model.WorkSchedule;
import oncall.model.WorkSchedules;

public class OutputView {

    private static final String NEXT_LINE = System.lineSeparator();

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printWorkSchedules(WorkSchedules workSchedules) {
        StringBuilder sb = new StringBuilder();
        for (WorkSchedule workSchedule : workSchedules.getWorkSchedules()) {
            sb.append(workSchedule.getMonth()).append("월 ").append(workSchedule.getDate()).append("일 ")
                    .append(workSchedule.getDayOfWeek()).append(" ").append(workSchedule.getWorker().getName())
                    .append(NEXT_LINE);
        }
        System.out.println(sb);
    }
}
