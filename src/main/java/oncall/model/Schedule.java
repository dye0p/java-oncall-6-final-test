package oncall.model;

import java.util.ArrayList;
import java.util.List;

public class Schedule {

    private final Calender calender;
    private final Workers workers;

    public Schedule(Calender calender, Workers workers) {
        this.calender = calender;
        this.workers = workers;
    }

    public ScheduleResults createSchedule() {
        int month = calender.getMonth();
        int monthLength = calender.getMonthLength();
        int dayOfWeekValue = getDayOfWeekValue();

        //근무표 생성
        List<ScheduleResult> scheduleResults = new ArrayList<>();
        for (int date = 1; date <= monthLength; date++) {
            //요일
            String dayOfWeek = calender.getDayOfWeek(dayOfWeekValue++);

            //해당 하는 요일에 맞는 근무자를 가져온다.
            Worker worker = workers.findWorkerBy(dayOfWeek, month, date);

            ScheduleResult scheduleResult = ScheduleResult.of(month, date, dayOfWeek, worker.getName());
            scheduleResults.add(scheduleResult);
        }
        return ScheduleResults.of(scheduleResults);
    }

    private int getDayOfWeekValue() {
        DayOfWeek startDayOfWeek = calender.getStartDayOfWeek();
        return startDayOfWeek.getValue();
    }
}
