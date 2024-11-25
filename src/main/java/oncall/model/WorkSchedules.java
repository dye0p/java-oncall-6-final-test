package oncall.model;

import java.time.DayOfWeek;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class WorkSchedules {

    private final Calender calender;
    private final Workers workers;

    public WorkSchedules(Calender calender, Workers workers) {
        this.calender = calender;
        this.workers = workers;
    }

    //근무표를 생성해라
    public List<WorkSchedule> createWorkSchedule() {
        //근무표를 만드려면?

        //어느 달의 어느 요일에 시작하는지 알아야 한다.
        //무조건 1일부터 시작한다.
        //해당 하는 달의 1일 부터 말일까지 가져온다.
        int month = calender.getMonth();
        YearMonth endDate = calender.getScheduleMonth(); // 해당 달의 말일

        //1일 부터 해당 말일까지 근무표를 출력 해야한다.
        //근무 시작은 입력받은 요일부터 시작한다.

        //일수를 돌면서 근무표를 작성한다.
        List<WorkSchedule> workSchedules = new ArrayList<>();
        for (int date = 1; date <= endDate.atEndOfMonth().lengthOfMonth(); date++) {

            //해당 달의 날짜에 해당하는 요일을 가져온다.
            DayOfWeek dayOfTheWeek = calender.getDayOfTheWeekByDate(date);
            String dayOfWeek = DayOfTheWeek.getDayOfWeek(dayOfTheWeek); //요일

            //평일이면서 법적 공휴일 이라면 휴일을 표기한다.
            if (isHolidayAndWeekday(dayOfWeek, month, date)) {
                dayOfWeek = dayOfWeek + "(휴일)";
            }

            //해당 요일에 근무하는 근무자를 찾는다
            String worker = workers.findWorkerByDayOfWeek(month, date, dayOfWeek);

            WorkSchedule workSchedule = new WorkSchedule(month, date, dayOfWeek, worker);

            workSchedules.add(workSchedule);
        }
        return workSchedules;
    }

    private boolean isHolidayAndWeekday(String dayOfWeek, int month, int date) {
        return DayOfTheWeek.isWeekday(dayOfWeek) && Holidays.isHoliday(month, date);
    }
}
