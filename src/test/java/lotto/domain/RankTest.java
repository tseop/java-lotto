package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {
    @DisplayName("등수에 없는 값을 전달 시 에러가 발생된다.")
    @Test
    void getRankExceptionTest() {
        // given
        int match = 10;
        int bonus = 0;

        // when & then
        assertThatThrownBy(() -> Rank.getRank(match, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("등수의 당첨금을 요청하면 해당 등수의 당첨 금액을 반환한다.")
    @Test
    void winningPriceTest() {
        // given
        long result = 2_000_000_000;

        // when
        Rank rank = Rank.FIRST_PRICE;

        // then
        assertThat(rank.getWinningPrice())
                .isEqualTo(result);
    }


    @DisplayName("5등에 당첨되는 값을 전달 시 5등을 반환한다.")
    @Test
    void fiveRankTest() {
        // given
        int match = 3;
        int bonus = 0;
        Rank result = Rank.FIVE_PRICE;

        // when
        Rank rank = Rank.getRank(match, bonus);

        // then
        assertThat(result)
                .isEqualTo(rank);
    }

    @DisplayName("4등에 당첨되는 값을 전달 시 5등을 반환한다.")
    @Test
    void fourRankTest() {
        // given
        int match = 4;
        int bonus = 0;
        Rank result = Rank.FOUR_PRICE;

        // when
        Rank rank = Rank.getRank(match, bonus);

        // then
        assertThat(result)
                .isEqualTo(rank);
    }

    @DisplayName("3등에 당첨되는 값을 전달 시 5등을 반환한다.")
    @Test
    void threeRankTest() {
        // given
        int match = 5;
        int bonus = 0;
        Rank result = Rank.THREE_PRICE;

        // when
        Rank rank = Rank.getRank(match, bonus);

        // then
        assertThat(result)
                .isEqualTo(rank);
    }

    @DisplayName("2등에 당첨되는 값을 전달 시 5등을 반환한다.")
    @Test
    void secondRankTest() {
        // given
        int match = 5;
        int bonus = 1;
        Rank result = Rank.SECOND_PRICE;

        // when
        Rank rank = Rank.getRank(match, bonus);

        // then
        assertThat(result)
                .isEqualTo(rank);
    }

    @DisplayName("1등에 당첨되는 값을 전달 시 5등을 반환한다.")
    @Test
    void firstRankTest() {
        // given
        int match = 6;
        int bonus = 0;
        Rank result = Rank.FIRST_PRICE;

        // when
        Rank rank = Rank.getRank(match, bonus);

        // then
        assertThat(result)
                .isEqualTo(rank);
    }

}