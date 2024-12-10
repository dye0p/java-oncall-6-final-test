package oncall.model;

public class Schedule {

    private final Calender calender;
    private final Workers workers;

    public Schedule(Calender calender, Workers workers) {
        this.calender = calender;
        this.workers = workers;
    }

    public void createSchedule() {
        //스케줄 생성

        //스케줄은 입력한 월의 요일부터 시작한다.

        //해당 하는 월의 마지막 일수를 가져온다.
        int monthLength = calender.getMonthLength();
        DayOfWeek startDayOfWeek = calender.getStartDayOfWeek();
        int dayOfWeekCount = startDayOfWeek.getValue();

        //근무표 생성
        for (int date = 1; date <= monthLength; date++) {
            //월 날짜 요일 근무자
            String dayOfWeek = calender.getDayOfWeek(dayOfWeekCount++);
        }
    }
}
