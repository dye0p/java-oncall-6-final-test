package oncall.model;

import java.util.Arrays;

public enum Holidays {

    SINJEONG(1, 1, "신정",
            ((monthValue, dateValue) -> monthValue == 1 && dateValue == 1)),
    SANILJEOL(3, 1, "삼일절",
            ((monthValue, dateValue) -> monthValue == 3 && dateValue == 1)),
    CHILDRENS_DAY(5, 5, "어린이날",
            ((monthValue, dateValue) -> monthValue == 5 && dateValue == 5)),
    MEMORIAL_DAY(6, 6, "현충일",
            ((monthValue, dateValue) -> monthValue == 6 && dateValue == 6)),
    LIBERATION_DAY(8, 15, "광복절",
            ((monthValue, dateValue) -> monthValue == 8 && dateValue == 15)),
    NATIONAL_FOUNDATION_DAY(10, 3, "개천절",
            ((monthValue, dateValue) -> monthValue == 10 && dateValue == 3)),
    HANGUL_DAY(10, 9, "한글날",
            ((monthValue, dateValue) -> monthValue == 10 && dateValue == 9)),
    CHRISTMAS(12, 25, "크리스마스",
            ((monthValue, dateValue) -> monthValue == 12 && dateValue == 25));

    private final int month;
    private final int date;
    private final String name;
    private final HolidayMatchers holidayMatchers;

    Holidays(int month, int date, String name, HolidayMatchers holidayMatchers) {
        this.month = month;
        this.date = date;
        this.name = name;
        this.holidayMatchers = holidayMatchers;
    }

    public static boolean isHoliday(int month, int date) {
        return Arrays.stream(Holidays.values())
                .anyMatch(holidays -> isMatchHoliday(month, date, holidays));
    }

    private static boolean isMatchHoliday(int month, int date, Holidays holidays) {
        return holidays.holidayMatchers.matchHoliday(month, date);
    }
}
