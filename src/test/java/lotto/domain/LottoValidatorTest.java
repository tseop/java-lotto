package lotto.domain;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.validator.LottoValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoValidatorTest {
    LottoValidator validator;

    @BeforeEach
    void setup() {
        validator = new LottoValidator();
    }

    @AfterEach
    void clear() {
        validator = null;
    }

    @DisplayName("배열의 크기가 6이 아니면 에러가 발생한다")
    @Test
    void sizeTest() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // when & then
        assertThatThrownBy(() -> validator.sizeValidate(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("범위 안의 값이 아니면 에러가 발생한다.")
    @Test
    void rangeTest() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 46);

        // when & then
        assertThatThrownBy(() -> validator.rangeValidate(numbers))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("로또 번호 내 중복 값이 있으면 에러가 발생한다. ")
    @Test
    void duplicateTest() {
        // given
        List<Integer> numbers = List.of(1, 2, 2, 3, 4, 5);

        // when & then
        assertThatThrownBy(() -> validator.duplicateSizeValidate(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }


}