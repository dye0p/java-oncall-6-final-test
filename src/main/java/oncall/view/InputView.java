package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    public String[] readMonthAndDayOfWeek() {
        System.out.print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");

        String monthAndDayOfWeek = Console.readLine();

        return InputConverter.convertMonthAndDayOfWeek(monthAndDayOfWeek);
    }

    public List<String> readWeekdayWorker() {
        System.out.print("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");

        String worker = Console.readLine();

        return InputConverter.convertWorker(worker);
    }
}
