package oncall.model;

import java.time.DayOfWeek;
import java.util.Arrays;
import oncall.exception.ErrorMessage;

public enum DayOfTheWeek {

    SUN_DAY("일", 7),
    MON_DAY("월", 1),
    TUES_DAY("화", 2),
    WEDNES_DAY("수", 3),
    THURS_DAY("목", 4),
    FRI_DAY("금", 5),
    SATUR_DAY("토", 6);

    private final String dayOfWeek;
    private final int value;

    DayOfTheWeek(String dayOrWeek, int value) {
        this.dayOfWeek = dayOrWeek;
        this.value = value;
    }

    public static DayOfTheWeek of(String dayOfWeek) {
        return Arrays.stream(values())
                .filter(values -> isDayOfWeek(dayOfWeek, values))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage()));
    }

    private static boolean isDayOfWeek(String dayOfWeek, DayOfTheWeek values) {
        return values.dayOfWeek.equals(dayOfWeek);
    }

    public static String getDayOfWeek(DayOfWeek dayOfTheWeek) {
        DayOfTheWeek dayOfTheWeekValue = findDayOfTheWeekValue(dayOfTheWeek);
        return dayOfTheWeekValue.dayOfWeek;
    }


    public static boolean isDayOff(String dayOfTheWeek) {
        return dayOfTheWeek.equals(SATUR_DAY.dayOfWeek) || dayOfTheWeek.equals(SUN_DAY.dayOfWeek);
    }

    public static boolean isWeekday(String dayOfWeek) {
        return !isDayOff(dayOfWeek);
    }

    private static DayOfTheWeek findDayOfTheWeekValue(DayOfWeek dayOfTheWeek) {
        return Arrays.stream(values())
                .filter(value -> value.value == dayOfTheWeek.getValue())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage()));
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public int getValue() {
        return value;
    }
}
