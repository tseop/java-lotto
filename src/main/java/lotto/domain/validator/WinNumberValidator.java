package lotto.domain.validator;

import java.lang.reflect.Array;
import lotto.domain.Lotto;
import org.assertj.core.util.Arrays;

public class WinNumberValidator {
    public void numericValidation(String[] dataArr) {
        for (String data : dataArr) {
            conversionExceptionValidation(data);
        }
    }

    public void commaValidation(String data) {
        int count = data.length() - data.replace(",", "").length();
        if (count != 5) {
            throw new IllegalArgumentException();
        }
    }

    private void conversionExceptionValidation(String data) {
        try {
            Integer.parseInt(data);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }
}
