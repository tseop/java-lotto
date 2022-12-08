package lotto.domain.validator;

import java.util.List;

public class LottoValidator {
    public void sizeValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void duplicateSizeValidate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public void rangeValidate(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (!(1 <= number && number <= 45)) {
                throw new IllegalArgumentException("[ERROR]");
            }
        });
    }


}
