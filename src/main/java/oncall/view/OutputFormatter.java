package oncall.view;

import java.util.List;
import java.util.StringJoiner;
import oncall.model.dto.WorkScheduleDto;

public class OutputFormatter {

    public static final String SCHEDULE_FORMAT = "%d월 %d일 %s %s";
    private static final String NEXT_LINE = System.lineSeparator();

    public static String formatScheduleResult(List<WorkScheduleDto> workSchedules) {
        StringJoiner sj = new StringJoiner(NEXT_LINE);
        for (WorkScheduleDto workSchedule : workSchedules) {
            String scheduleFormat = formatting(workSchedule);
            sj.add(scheduleFormat);
        }
        return sj.toString();
    }

    private static String formatting(WorkScheduleDto workSchedule) {
        return String.format(
                SCHEDULE_FORMAT,
                workSchedule.month(),
                workSchedule.date(),
                workSchedule.dayOfWeek(),
                workSchedule.worker()
        );
    }
}
