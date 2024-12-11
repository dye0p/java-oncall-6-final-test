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

    public void changeSequenceWorker() {
        for (int date = 1; date < scheduleResults.size(); date++) {
            ScheduleResult beforeWorker = scheduleResults.get(date - 1);
            ScheduleResult nextWorker = scheduleResults.get(date);

            findSequenceWorker(beforeWorker, nextWorker, date);
        }
    }

    private void findSequenceWorker(ScheduleResult beforeWorker, ScheduleResult nextWorker, int date) {
        if (isSameName(beforeWorker, nextWorker)) {
            //다음 근무자가 평일 이라면
            if (isWeekdayBy(nextWorker)) {
                //그 다음 평일 근무자와 위치를 바꿔야 한다.
                findChangeWorkerFromWeekday(date, nextWorker);
            }
            //다음 근무자가 휴일 이라면
            if (isHolyDayBy(nextWorker)) {
                findChangeWorkerFromHolyDay(date, nextWorker);
            }
        }
    }

    private boolean isSameName(ScheduleResult beforeWorker, ScheduleResult nextWorker) {
        return beforeWorker.getWorker().equals(nextWorker.getWorker());
    }

    private void findChangeWorkerFromHolyDay(int date, ScheduleResult nextWorker) {
        //그 다음 휴일 근무자와 위치를 바꿔야 한다.
        for (int i = date + 1; i < scheduleResults.size(); i++) {
            ScheduleResult changeWorker = scheduleResults.get(i);
            if (isHolyDayBy(changeWorker)) {
                changeWorkSchedule(changeWorker, nextWorker);
                break;
            }
        }
    }

    private void findChangeWorkerFromWeekday(int date, ScheduleResult nextWorker) {
        for (int i = date + 1; i < scheduleResults.size(); i++) {
            ScheduleResult changeWorker = scheduleResults.get(i);
            if (isWeekdayBy(changeWorker)) {
                changeWorkSchedule(changeWorker, nextWorker);
                break;
            }
        }
    }

    private boolean isWeekdayBy(ScheduleResult nextWorker) {
        return DayOfWeek.isWeekday(nextWorker.getDayOfWeek())
                && !HolyDay.isHolyDay(nextWorker.getMonth(), nextWorker.getDate());
    }

    private boolean isHolyDayBy(ScheduleResult nextWorker) {
        return DayOfWeek.isWeekend(nextWorker.getDayOfWeek())
                || HolyDay.isHolyDay(nextWorker.getMonth(), nextWorker.getDate());
    }

    private void changeWorkSchedule(ScheduleResult changeWorker, ScheduleResult nextWorker) {
        String changeWorkerName = changeWorker.getWorker();
        changeWorker.setWorker(nextWorker.getWorker());
        nextWorker.setWorker(changeWorkerName);
    }

    public List<ScheduleResult> getScheduleResults() {
        return new ArrayList<>(scheduleResults);
    }

}
