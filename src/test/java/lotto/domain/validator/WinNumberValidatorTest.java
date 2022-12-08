package lotto.domain.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinNumberValidatorTest {
    private static WinNumberValidator VALIDATOR;

    @BeforeEach
    void setup() {
        VALIDATOR = new WinNumberValidator();
    }

    @AfterEach
    void clear() {
        VALIDATOR = null;
    }

    @DisplayName("문자열 내 값이 숫자가 아니면 예외가 발생한다.")
    @Test
    void numericValidationTest() {
        // given
        String[] dataArr = {"1,2,3,4,5,a"};

        // when & then
        assertThatThrownBy(() -> VALIDATOR.numericValidation(dataArr))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열 내 ,가 5개가 아니면 예외가 발생한다.")
    @ValueSource(strings = {"1,2,3,4,5,6,",",,,,,,,,",",1,2,3,4,5,6"})
    @ParameterizedTest
    void commaCountTest(String data) {
        // given & when & then
        assertThatThrownBy(() -> VALIDATOR.commaValidation(data))
                .isInstanceOf(IllegalArgumentException.class);
    }


}