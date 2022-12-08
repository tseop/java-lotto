package lotto.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoGenerator {
    public List<Lotto> buyLottoes(int quantity) {
        List<Lotto> lottoes = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottoes.add(new Lotto(createNumbers()));
        }
        return lottoes;
    }

    private List<Integer> createNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
