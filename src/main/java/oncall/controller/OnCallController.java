package oncall.controller;

import java.util.List;
import java.util.function.Supplier;
import oncall.model.Calender;
import oncall.model.DayOffWorkers;
import oncall.model.ScheduleManager;
import oncall.model.WeekdayWorkers;
import oncall.model.WorkSchedules;
import oncall.model.Worker;
import oncall.model.Workers;
import oncall.model.dto.WorkScheduleDto;
import oncall.view.InputView;
import oncall.view.OutputView;

public class OnCallController {

    private final InputView inputView;
    private final OutputView outputView;

    public OnCallController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Calender calender = tryReadMonthAndDay();
        Workers workers = tryReadWorkers();

        displayWorkSchedules(calender, workers);
    }

    private void displayWorkSchedules(Calender calender, Workers workers) {
        WorkSchedules workSchedules = getWorkSchedules(calender, workers);
        List<WorkScheduleDto> workScheduleResult = workSchedules.mapToDto(workSchedules);
        outputView.printWorkSchedules(workScheduleResult);
    }

    private WorkSchedules getWorkSchedules(Calender calender, Workers workers) {
        ScheduleManager scheduleManager = new ScheduleManager(calender, workers);
        return scheduleManager.createWorkSchedule();
    }

    private <T> T requestRead(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception.getMessage());
            }
        }
    }

    private Calender tryReadMonthAndDay() {
        return requestRead(() -> {
            String[] monthAndDay = inputView.readMonthAndDay();
            int month = Integer.parseInt(monthAndDay[0]);
            String day = monthAndDay[1];
            return Calender.of(month, day);
        });
    }

    private Workers tryReadWorkers() {
        return requestRead(() -> {
            WeekdayWorkers weekdayWorkers = tryWeekdayWorkers();
            DayOffWorkers dayOffWorkers = tryDayOffWorkers();
            return Workers.of(weekdayWorkers, dayOffWorkers);
        });
    }

    private WeekdayWorkers tryWeekdayWorkers() {
        return requestRead(() -> WeekdayWorkers.from(inputView.readWeekdayWorkers()));
    }

    private DayOffWorkers tryDayOffWorkers() {
        List<Worker> dayOffWorkers = inputView.readDayOffWorkers();
        return DayOffWorkers.from(dayOffWorkers);
    }
}
