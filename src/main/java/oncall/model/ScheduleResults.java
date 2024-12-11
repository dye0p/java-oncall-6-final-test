package oncall.model;

import java.util.ArrayList;
import java.util.List;

public class ScheduleResults {

    private final List<ScheduleResult> scheduleResults;

    public ScheduleResults(List<ScheduleResult> scheduleResults) {
        this.scheduleResults = scheduleResults;
    }

    public static ScheduleResults of(List<ScheduleResult> scheduleResults) {
        return new ScheduleResults(scheduleResults);
    }

    public List<ScheduleResult> getScheduleResults() {
        return new ArrayList<>(scheduleResults);
    }
}
