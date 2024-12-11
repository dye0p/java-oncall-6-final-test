package oncall.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import oncall.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MonthTest {

    @DisplayName("존재하지 않는 달 이라면 예외를 발생한다.")
    @Test
    void nonMonth() {
        //given
        int month = 0;

        //when //then
        assertThatThrownBy(() -> Month.of(month))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_INPUT.getErrorMessage());
    }

    @DisplayName("해당 하는 달의 길이를 반환한다.")
    @Test
    void getMonthLength() {
        //given
        int month = 5;

        //when
        int monthLength = Month.getMonthLength(month);

        //then
        assertThat(monthLength).isEqualTo(31);
    }

}
