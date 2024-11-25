package oncall.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String[] readMonthAndDay() {
        System.out.print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
        String monthAndDay = Console.readLine();

        return InputConvertor.convertMonthAndDay(monthAndDay);
    }
}
