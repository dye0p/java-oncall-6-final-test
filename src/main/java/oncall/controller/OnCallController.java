package oncall.controller;

import java.util.List;
import oncall.model.Calender;
import oncall.model.Day;
import oncall.model.DayOffWorkers;
import oncall.model.Month;
import oncall.model.ScheduleManager;
import oncall.model.WeekdayWorkers;
import oncall.model.WorkSchedules;
import oncall.model.Worker;
import oncall.model.Workers;
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
        outputView.printWorkSchedules(workSchedules);
    }

    private WorkSchedules getWorkSchedules(Calender calender, Workers workers) {
        ScheduleManager scheduleManager = new ScheduleManager(calender, workers);
        return scheduleManager.createWorkSchedule();
    }

    private Calender tryReadMonthAndDay() {
        while (true) {
            try {
                String[] monthAndDay = inputView.readMonthAndDay();

                Month month = new Month(Integer.parseInt(monthAndDay[0]));
                Day day = new Day(monthAndDay[1]);

                return new Calender(month, day);
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception.getMessage());
            }
        }
    }

    private Workers tryReadWorkers() {
        while (true) {
            try {
                WeekdayWorkers weekdayWorkers = tryWeekdayWorkers();
                DayOffWorkers dayOffWorkers = tryDayOffWorkers();
                return Workers.of(weekdayWorkers, dayOffWorkers);
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception.getMessage());
            }
        }
    }

    private WeekdayWorkers tryWeekdayWorkers() {
        while (true) {
            try {
                List<Worker> weekdayWorkers = inputView.readWeekdayWorkers();
                return WeekdayWorkers.from(weekdayWorkers);
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception.getMessage());
            }
        }
    }

    private DayOffWorkers tryDayOffWorkers() {
        List<Worker> dayOffWorkers = inputView.readDayOffWorkers();
        return DayOffWorkers.from(dayOffWorkers);
    }
}
