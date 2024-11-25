package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import oncall.model.Worker;

public class InputView {

    public String[] readMonthAndDay() {
        System.out.print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
        String monthAndDay = Console.readLine();

        return InputConvertor.convertMonthAndDay(monthAndDay);
    }

    public List<Worker> readWeekdayWorkers() {
        System.out.print("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        String workers = Console.readLine();

        return InputConvertor.convertWorkers(workers);
    }

    public List<Worker> readDayOffWorkers() {
        System.out.print("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        String workers = Console.readLine();

        return InputConvertor.convertWorkers(workers);
    }
}
