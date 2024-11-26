package oncall.model.dto;

import oncall.model.WorkSchedule;

public record WorkScheduleDto(int month, int date, String dayOfWeek, String worker) {

    public static WorkScheduleDto from(WorkSchedule workSchedule) {
        return new WorkScheduleDto(workSchedule.getMonth(), workSchedule.getDate(), workSchedule.getDayOfWeek(),
                workSchedule.getWorker().getName());
    }
}
