package oncall.model;

import java.util.Arrays;
import oncall.exception.ErrorMessage;

public enum DayOfWeek {

    MON("월", 0),
    TUE("화", 1),
    WED("수", 2),
    THU("목", 3),
    FRI("금", 4),
    SAT("토", 5),
    SUN("일", 6),
    ;

    private final String name;
    private final int value;

    DayOfWeek(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public static DayOfWeek of(String date) {
        return Arrays.stream(values())
                .filter(value -> isSameName(date, value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getErrorMessage()));
    }

    public static String getValue(int dayOfWeekValue) {
        DayOfWeek[] values = values();
        return values[(dayOfWeekValue % values.length)].name;
    }

    public static boolean isWeekend(String dayOfWeek) {
        return dayOfWeek.equals(DayOfWeek.SAT.name) || dayOfWeek.equals(DayOfWeek.SUN.name);
    }

    public static boolean isWeekday(String dayOfWeek) {
        return !isWeekend(dayOfWeek);
    }

    public int getValue() {
        return value;
    }

    private static boolean isSameName(String date, DayOfWeek value) {
        return value.name.equals(date);
    }
}
