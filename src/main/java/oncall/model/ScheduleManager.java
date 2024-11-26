package oncall.model;

import java.util.ArrayList;
import java.util.List;

public class ScheduleManager {

    private final Calender calender;
    private final Workers workers;

    public ScheduleManager(Calender calender, Workers workers) {
        this.calender = calender;
        this.workers = workers;
    }

    public WorkSchedules createWorkSchedule() {
        //해당 하는 달의 1일 부터 말일까지 가져온다.
        int month = calender.getMonth();
        int endDate = calender.getScheduleMonth(); // 해당 달의 말일

        //일수를 돌면서 근무표를 작성한다.
        List<WorkSchedule> workSchedules = createSchedule(endDate, month);
        return new WorkSchedules(workSchedules).sequenceWork();
    }

    private List<WorkSchedule> createSchedule(int endDate, int month) {
        List<WorkSchedule> workSchedules = new ArrayList<>();
        for (int date = 1; date <= endDate; date++) {
            //해당 달의 날짜에 해당하는 요일을 가져온다.
            String dayOfWeek = calender.getDayOfTheWeekByDate(date);

            //평일이면서 법적 공휴일 이라면 휴일을 표기한다.
            dayOfWeek = calender.isHolidayAndWeekday(dayOfWeek, month, date);

            //해당 요일에 근무하는 근무자를 찾는다
            Worker worker = workers.findWorkerByDayOfWeek(month, date, dayOfWeek);

            WorkSchedule workSchedule = new WorkSchedule(month, date, dayOfWeek, worker);
            workSchedules.add(workSchedule);
        }
        return workSchedules;
    }
}
