package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.generator.LottoGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGeneratorTest {

    LottoGenerator generator;

    @BeforeEach
    void setup() {
        generator = new LottoGenerator();
    }

    @AfterEach
    void clear() {
        generator = null;
    }

    @DisplayName("구매를 요청한 수만큼 로또가 구매가 된다.")
    @ValueSource(ints = {4, 7, 9, 10})
    @ParameterizedTest
    void buyLottoTest(int quantity) {
        // given
        int result = quantity;

        // when
        List<Lotto> lottos = generator.buyLottoes(quantity);

        // then
        assertThat(lottos.size())
                .isEqualTo(result);
    }
}