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

    public static String getDayOfWeek(DayOfWeek dayOfTheWeek) {
        DayOfTheWeek dayOfTheWeekValue = findDayOfTheWeekValue(dayOfTheWeek);
        return dayOfTheWeekValue.dayOfWeek;
    }

    private static DayOfTheWeek findDayOfTheWeekValue(DayOfWeek dayOfTheWeek) {
        return Arrays.stream(values())
                .filter(value -> value.value == dayOfTheWeek.getValue())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage()));
    }

    public static boolean isDayOff(String dayOfTheWeek) {
        //휴일인지 판단해줘
        return dayOfTheWeek.equals(SATUR_DAY.dayOfWeek) || dayOfTheWeek.equals(SUN_DAY.dayOfWeek);
    }

    public static boolean isWeekday(String dayOfWeek) {
        //평일인지 판단해줘
        return !isDayOff(dayOfWeek);
    }
}
