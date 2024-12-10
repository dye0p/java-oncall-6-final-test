package oncall.controller;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.function.Supplier;
import oncall.exception.ErrorMessage;
import oncall.model.Calender;
import oncall.model.DayOfWeek;
import oncall.model.Month;
import oncall.model.WeekdayWorkers;
import oncall.model.WeekendWorkers;
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
        Calender calender = tryMontAndDayOfWeek();
        Workers workers = tryWorkers();

    }

    private Workers tryWorkers() {
        return requestRead(() -> {
            WeekdayWorkers weekdayWorkers = tryWeekdayWorker();
            WeekendWorkers weekendWorkers = tryWeekendWorker();

            return new Workers(weekdayWorkers, weekendWorkers);
        });
    }

    private WeekdayWorkers tryWeekdayWorker() {
        return requestRead(() -> {
            List<String> weekdayWorkers = inputView.readWeekdayWorker();

            Deque<Worker> weekdayWorkerDeq = new ArrayDeque<>();
            for (String weekdayWorker : weekdayWorkers) {
                Worker worker = Worker.from(weekdayWorker);
                weekdayWorkerDeq.addLast(worker);
            }
            return WeekdayWorkers.of(weekdayWorkerDeq);
        });

    }

    private WeekendWorkers tryWeekendWorker() {
        List<String> weekendWorker = inputView.readWeekendWorker();

        Deque<Worker> weekdayWorkerDeq = new ArrayDeque<>();
        for (String weekdayWorker : weekendWorker) {
            Worker worker = Worker.from(weekdayWorker);
            weekdayWorkerDeq.addLast(worker);
        }
        return WeekendWorkers.of(weekdayWorkerDeq);
    }

    private Calender tryMontAndDayOfWeek() {
        return requestRead(() -> {
            String[] monthAndDate = inputView.readMonthAndDayOfWeek();

            int inputMonth = parseMonth(monthAndDate);
            String inputDayOfWeek = monthAndDate[1];

            Month month = Month.of(inputMonth);
            DayOfWeek dateOfWeek = DayOfWeek.of(inputDayOfWeek);

            return Calender.of(month, dateOfWeek);
        });
    }

    private int parseMonth(String[] monthAndDate) {
        try {
            return Integer.parseInt(monthAndDate[0]);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getErrorMessage());
        }
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
}
