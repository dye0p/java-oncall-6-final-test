package oncall.model;

import java.util.ArrayList;
import java.util.List;
import oncall.model.dto.WorkScheduleDto;

public class WorkSchedules {

    private final List<WorkSchedule> workSchedules;

    public WorkSchedules(List<WorkSchedule> workSchedules) {
        this.workSchedules = workSchedules;
    }

    public List<WorkSchedule> getWorkSchedules() {
        return workSchedules;
    }

    //2일 연속 근무하는 근무자의 근무 순서를 바꿔야 한다.
    public WorkSchedules sequenceWork() {

        //2일 연속 근무하는 근무자가 있는지 찾는다.
        for (int index = 1; index < workSchedules.size(); index++) {
            //순회하며 현재 근무자가 이전 근무자와 동일한지 확인한다.
            WorkSchedule worker = workSchedules.get(index);
            WorkSchedule beforeWorker = workSchedules.get(index - 1);

            if (worker.isSameWorker(beforeWorker)) {
                //휴일에 근무 해야 한다면
                if (worker.isHoliday()) {
                    for (int j = index + 1; j < workSchedules.size(); j++) {
                        WorkSchedule nextWorkSchedule = workSchedules.get(j);
                        if (nextWorkSchedule.isHoliday()) {
                            String name = nextWorkSchedule.getWorker().getName();

                            //근무자를 바꾼다.
                            nextWorkSchedule.changeWorkerName(worker.getWorker().getName());
                            worker.changeWorkerName(name);
                            break;
                        }
                    }
                }
                //평일에 근무 해야 한다면
                if (!worker.isHoliday()) {
                    for (int j = index + 1; j < workSchedules.size(); j++) {
                        WorkSchedule nextWorkSchedule = workSchedules.get(j);
                        if (!nextWorkSchedule.isHoliday()) {
                            String name = nextWorkSchedule.getWorker().getName();

                            //근무자를 바꾼다.
                            nextWorkSchedule.changeWorkerName(worker.getWorker().getName());
                            worker.changeWorkerName(name);
                            break;
                        }
                    }
                }
            }
        }
        return this;
    }

    public List<WorkScheduleDto> mapToDto(WorkSchedules workSchedules) {
        List<WorkScheduleDto> workScheduleResult = new ArrayList<>();
        for (WorkSchedule workSchedule : workSchedules.getWorkSchedules()) {
            workScheduleResult.add(WorkScheduleDto.from(workSchedule));
        }
        return workScheduleResult;
    }
}
