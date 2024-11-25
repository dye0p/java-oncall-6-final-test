package oncall.model;

public enum Holidays {

    SINJEONG(1, 1, "신정",
            ((month1, date1) -> true)),
    SANILJEOL(3, 1, "삼일절",
            ((month1, date1) -> true)),
    CHILDRENS_DAY(5, 5, "어린이날",
            ((month1, date1) -> true)),
    MEMORIAL_DAY(6, 6, "현충일",
            ((month1, date1) -> true)),
    LIBERATION_DAY(8, 15, "광복절",
            ((month1, date1) -> true)),
    NATIONAL_FOUNDATION_DAY(10, 3, "개천절",
            ((month1, date1) -> true)),
    HANGUL_DAY(10, 9, "한글날",
            ((month1, date1) -> true)),
    CHRISTMAS(12, 25, "크리스마스",
            ((month1, date1) -> true));

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
        return (month == 1 && date == 1
                || month == 3 && date == 1 ||
                month == 5 && date == 5 ||
                month == 6 && date == 6 ||
                month == 8 && date == 15 ||
                month == 10 && date == 3 ||
                month == 10 && date == 9 ||
                month == 12 && date == 25);
    }
}
