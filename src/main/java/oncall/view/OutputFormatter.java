package oncall.view;

import java.util.List;
import java.util.StringJoiner;
import oncall.model.ScheduleResult;

public class OutputFormatter {

    private static final String NEXT_LINE = System.lineSeparator();

    public static String formatScheduleResult(List<ScheduleResult> scheduleResults) {
        StringJoiner sj = new StringJoiner(NEXT_LINE);

        for (ScheduleResult scheduleResult : scheduleResults) {
            String format = String.format("%s월 %s일 %s %s", scheduleResult.getMonth(), scheduleResult.getDate(),
                    scheduleResult.getDayOfWeek()
                    , scheduleResult.getWorker());

            sj.add(format);
        }
        return sj.toString();
    }
}
