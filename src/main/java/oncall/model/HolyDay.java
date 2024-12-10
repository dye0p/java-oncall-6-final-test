package oncall.model;

public enum HolyDay {

    SIN_JUNG(1, 1),
    SAMIL_JEOL(3, 1),
    CHILDREN_DAY(5, 5),
    MEMORIAL_DAY(6, 6),
    NATIONAL_LIBERATION_DAY(8, 15),
    NATIONAL_FOUNDATION_DAY(10, 3),
    HANGUL_DAY(10, 9),
    CHRISTMAS(12, 25),
    ;

    private final int month;
    private final int date;

    HolyDay(int month, int date) {
        this.month = month;
        this.date = date;
    }
}
