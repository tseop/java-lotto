package lotto.domain;

import java.util.List;
import lotto.domain.validator.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;
    private static final LottoValidator VALIDATOR = new LottoValidator();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        VALIDATOR.sizeValidate(numbers);
        VALIDATOR.duplicateSizeValidate(numbers);
        VALIDATOR.rangeValidate(numbers);
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }
}
