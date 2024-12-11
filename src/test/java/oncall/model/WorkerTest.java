package oncall.model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import oncall.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WorkerTest {

    @DisplayName("근무자의 이름의 길이가 5를 초과하면 예외가 발생한다.")
    @Test
    void exceedNameSize() {
        //given
        String name = "우아한테크코";

        //when //then
        assertThatThrownBy(() -> Worker.from(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_INPUT.getErrorMessage());
    }

    @DisplayName("근무자의 이름의 길이가 5 이하 라면 예외가 발생하지 않는다.")
    @Test
    void nonExceedNameSize() {
        //given
        String name = "우아한테크";

        //when //then
        assertThatCode(() -> Worker.from(name))
                .doesNotThrowAnyException();
    }
}
