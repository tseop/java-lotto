package lotto.domain.convertor;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinNumberConverterTest {

    private static WinNumberConverter CONVERTER;

    @BeforeEach
    void setup() {
        CONVERTER = new WinNumberConverter();
    }

    @AfterEach
    void clear() {
        CONVERTER = null;
    }

    @DisplayName("정상적인 당첨 번호를 받았을 때 정상적인 로또로 변환해준다")
    @Test
    void createLottoTest() {
        // given
        String data = "1,2,3,4,5,6";
        List<Integer> result = List.of(1, 2, 3, 4, 5, 6);

        // when
        Lotto lotto = CONVERTER.createLotto(data);

        // then
        assertThat(lotto.getNumbers())
                .containsAll(result);
    }




}