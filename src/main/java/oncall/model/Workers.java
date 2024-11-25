package oncall.model;

public class Workers {

    private final WeekdayWorkers weekdayWorkers;
    private final DayOffWorkers dayOffWorkers;

    public Workers(WeekdayWorkers weekdayWorkers, DayOffWorkers dayOffWorkers) {
        weekdayWorkers.isContain(dayOffWorkers.getDayOffWorkers());
        dayOffWorkers.isContain(weekdayWorkers.getWeekdayWorkers());

        this.weekdayWorkers = weekdayWorkers;
        this.dayOffWorkers = dayOffWorkers;
    }

    public Worker findWorkerByDayOfWeek(int month, int date, String dayOfTheWeek) {
        //요일에 따라서 가능한 근무자가 다르다.
        //요일이 휴일인지 확인해야 한다. //(휴일은 토,일,법적 공휴일)

        //휴일이라면
        if (DayOfTheWeek.isDayOff(dayOfTheWeek) || Holidays.isHoliday(month, date)) {
            //휴일 순번의 근무자 리턴
            return dayOffWorkers.getWorker();
        }

        //평일(월~금) 이라면
        return weekdayWorkers.getWorker();
    }
}
