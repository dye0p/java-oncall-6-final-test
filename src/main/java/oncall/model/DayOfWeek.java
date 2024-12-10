package oncall.model;

import java.util.Arrays;
import oncall.exception.ErrorMessage;

public enum DayOfWeek {

    MON("월"),
    TUE("화"),
    WED("수"),
    THU("목"),
    FRI("금"),
    SAT("토"),
    SUN("일"),
    ;

    private final String name;

    DayOfWeek(String name) {
        this.name = name;
    }

    public static DayOfWeek of(String date) {
        return Arrays.stream(values())
                .filter(value -> value.name.equals(date))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getErrorMessage()));
    }
}
