package lotto.domain.cal;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import lotto.domain.generator.LottoGenerator;
import lotto.domain.rank.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCalculatorTest {
    private static LottoCalculator CALCULATOR;

    @BeforeEach
    void setup() {
        CALCULATOR = new LottoCalculator();
    }

    @AfterEach
    void clear() {
        CALCULATOR = null;
    }

/*
    @DisplayName("로또 등수 정보가 담긴 Map을 넘기면 총 당첨금액을 알려준다.")
    @Test
    void totalMoneyCalTest() {
        // given
        Map<Rank, Integer> lottoes = new HashMap<>();
        lottoes.put(Rank.FIVE_PRICE, 5);
        lottoes.put(Rank.FIRST_PRICE, 1);
        lottoes.put(Rank.FOUR_PRICE, 3);

        long result = 2000175000L;

        // when
        long total = CALCULATOR.totalWiningMoneyCalculator(lottoes);

        // then
        assertThat(result)
                .isEqualTo(total);
    }
*/

    @DisplayName("총 수익률 계산")
    @Test
    void rateCalTest() {
        // given
        Map<Rank, Integer> lottoes = new HashMap<>();
        lottoes.put(Rank.FIVE_PRICE, 20);
        int buyMoney = 100 * 1000;

        double result = 100.0;

        // when
        double rate = CALCULATOR.rateCalculator(lottoes, buyMoney);

        // then
        assertThat(rate)
                .isEqualTo(result);
    }


}