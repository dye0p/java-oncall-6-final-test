package oncall;

import java.time.YearMonth;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class localDate {

    @DisplayName("aa")
    @Test
    void aa() {
        //given
        YearMonth yearMonth = YearMonth.of(2023, 2);
        //when
        System.out.println(yearMonth.atEndOfMonth().lengthOfMonth());

        //then
    }
}
