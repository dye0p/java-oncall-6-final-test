package oncall.model;

import java.util.Arrays;
import oncall.exception.ErrorMessage;

public enum Month {

    JAN(1, 31),
    FEB(2, 28),
    MAR(3, 31),
    APR(4, 30),
    MAY(5, 31),
    JUN(6, 30),
    JUL(7, 31),
    AUG(8, 31),
    SEP(9, 30),
    OCT(10, 31),
    NOV(11, 30),
    DEC(12, 31),
    ;

    private final int month;
    private final int length;

    Month(int month, int length) {
        this.month = month;
        this.length = length;
    }

    public static Month of(int month) {
        return Arrays.stream(values())
                .filter(value -> value.month == month)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getErrorMessage()));
    }
}
