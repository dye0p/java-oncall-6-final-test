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

    public void findSequenceWorker() {
        for (int date = 1; date < scheduleResults.size(); date++) {
            ScheduleResult beforeWorker = scheduleResults.get(date - 1);
            ScheduleResult nextWorker = scheduleResults.get(date);

            //연속된 근무자 라면
            if (beforeWorker.getWorker().equals(nextWorker.getWorker())) {
                //다음 근무자가 평일 이라면
                if (DayOfWeek.isWeekday(nextWorker.getDayOfWeek())
                        && !HolyDay.isHolyDay(nextWorker.getMonth(), nextWorker.getDate())) {

                    //그 다음 평일 근무자와 위치를 바꿔야 한다.
                    for (int i = date + 1; i < scheduleResults.size(); i++) {
                        ScheduleResult changeWorker = scheduleResults.get(i);

                        //바꿔야 하는 근무자가 평일 이라면
                        if (DayOfWeek.isWeekday(changeWorker.getDayOfWeek())
                                || !HolyDay.isHolyDay(changeWorker.getMonth(), changeWorker.getDate())) {

                            //둘의 순서를 바꾼다.
                            String changeWorkerWorker = changeWorker.getWorker();
                            changeWorker.setWorker(nextWorker.getWorker());
                            nextWorker.setWorker(changeWorkerWorker);
                            break;
                        }
                    }
                }
                //다음 근무자가 휴일 이라면
                if (DayOfWeek.isWeekend(nextWorker.getDayOfWeek())
                        || HolyDay.isHolyDay(nextWorker.getMonth(), nextWorker.getDate())) {

                    //그 다음 휴일 근무자와 위치를 바꿔야 한다.
                    for (int i = date + 1; i < scheduleResults.size(); i++) {
                        ScheduleResult changeWorker = scheduleResults.get(i);

                        //바꿔야 하는 근무자가 휴일 이라면
                        if (DayOfWeek.isWeekend(changeWorker.getDayOfWeek())
                                || HolyDay.isHolyDay(changeWorker.getMonth(), changeWorker.getDate())) {

                            //둘의 순서를 바꾼다. (이름만 바꿔야 한다)
                            String changeWorkerWorker = changeWorker.getWorker();
                            changeWorker.setWorker(nextWorker.getWorker());
                            nextWorker.setWorker(changeWorkerWorker);
                            break;
                        }
                    }
                }
            }
        }
    }

    public List<ScheduleResult> getScheduleResults() {
        return new ArrayList<>(scheduleResults);
    }

}
