package lotto.domain.cal;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import lotto.domain.rank.Rank;

public class LottoCalculator {
    public double rateCalculator(Map<Rank, Integer> lottoes, long buyMoney) {
        return (double) totalWiningMoneyCalculator(lottoes) / buyMoney * 100;
    }

    private long totalWiningMoneyCalculator(Map<Rank, Integer> lottoes) {
        AtomicLong money = new AtomicLong();
        lottoes.forEach((rank, count) -> {
            money.addAndGet(rank.getWinningMoney() * count);
        });
        return money.get();
    }
}
