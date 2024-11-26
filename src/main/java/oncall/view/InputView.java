package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import oncall.model.Worker;

public class InputView {

    private static final String READ_MONTH_DAY_MESSAGE = "비상 근무를 배정할 월과 시작 요일을 입력하세요> ";
    private static final String READ_WEEKDAY_WORKER_MESSAGE = "평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ";
    private static final String READ_DAY_OFF_WORKER_MESSAGE = "휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ";

    public String[] readMonthAndDay() {
        System.out.print(READ_MONTH_DAY_MESSAGE);
        String monthAndDay = Console.readLine();

        return InputConvertor.convertMonthAndDay(monthAndDay);
    }

    public List<Worker> readWeekdayWorkers() {
        System.out.print(READ_WEEKDAY_WORKER_MESSAGE);
        String workers = Console.readLine();

        return InputConvertor.convertWorkers(workers);
    }

    public List<Worker> readDayOffWorkers() {
        System.out.print(READ_DAY_OFF_WORKER_MESSAGE);
        String workers = Console.readLine();

        return InputConvertor.convertWorkers(workers);
    }
}
