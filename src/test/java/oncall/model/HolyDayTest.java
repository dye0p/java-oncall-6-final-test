package oncall.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HolyDayTest {

    @DisplayName("법정 공휴일이라면 true를 반환한다.")
    @Test
    void isHolyDay() {
        //given
        int month = 5;
        int date = 5;

        //when
        boolean result = HolyDay.isHolyDay(month, date);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("법정 공휴일이 아니라면 false를 반환한다.")
    @Test
    void isNotHolyDay() {
        //given
        int month = 5;
        int date = 3;

        //when
        boolean result = HolyDay.isHolyDay(month, date);

        //then
        assertThat(result).isFalse();
    }

}
