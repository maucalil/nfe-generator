package com.mauricio.domain.converters;

import java.math.BigDecimal;

public class StringConverter {

    public static BigDecimal toBigDecimal(String input, int size) {
        if (input.length() != size && input.matches("[0-9]{" + size + "}")) {
            throw new IllegalArgumentException("A string não possui" + size + "dígitos.");
        }

        int splitIndex = size - 2;
        String integerPart = input.substring(0, splitIndex);
        String decimalPart = input.substring(splitIndex);

        String bigDecimalString = integerPart + "." + decimalPart;

        return new BigDecimal(bigDecimalString);
    }

    public static BigDecimal toBigDecimal(String input) {
        return toBigDecimal(input, 15);
    }
}
