package com.mauricio.domain.converters;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public static XMLGregorianCalendar toXMLGregorianCalendar(String input) {
        try {
            // Primeiro, crie um objeto SimpleDateFormat para analisar a data original
            SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyMMdd");
            Date originalDate = originalFormat.parse(input);

            SimpleDateFormat xmlFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date = xmlFormat.format(originalDate);

            DatatypeFactory dataTypeFactory = DatatypeFactory.newInstance();

            return dataTypeFactory.newXMLGregorianCalendar(date);
        } catch (ParseException | DatatypeConfigurationException e) {
            e.printStackTrace();
            return null;
        }
    }
}
