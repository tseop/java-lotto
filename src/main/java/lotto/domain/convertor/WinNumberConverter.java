package lotto.domain.convertor;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.validator.WinNumberValidator;

public class WinNumberConverter {
    private static final WinNumberValidator VALIDATOR = new WinNumberValidator();

    public Lotto createLotto(String data) {
        VALIDATOR.commaValidation(data);
        String[] dataArr = data.split(",");
        VALIDATOR.numericValidation(dataArr);
        return new Lotto(createNumbers(dataArr));
    }

    private List<Integer> createNumbers(String[] dataArr) {
        List<Integer> numbers = new ArrayList<>();
        for (String data : dataArr) {
            numbers.add(numberConversion(data));
        }
        return numbers;
    }

    private int numberConversion(String data) {
        return Integer.parseInt(data);
    }
}
