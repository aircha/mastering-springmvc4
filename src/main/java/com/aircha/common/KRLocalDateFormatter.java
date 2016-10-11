package com.aircha.common;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;

import static java.awt.SystemColor.text;

/**
 * Created by 정현 on 2016-10-12.
 */
public class KRLocalDateFormatter implements Formatter {
    private static final String KR_PATTERN = "yyyy/MM/dd";
    private static final String NORMAL_PATTERN = "dd/MM/yyyy";

    @Override
    public Object parse(String text, Locale locale) throws ParseException {
        return LocalDate.parse(text, DateTimeFormatter.ofPattern(getPattern(locale)));
    }

    @Override
    public String print(Object object, Locale locale) {
        return DateTimeFormatter.ofPattern(getPattern(locale)).format((TemporalAccessor) object);
    }

    public static String getPattern(Locale locale) {
        return isKorea(locale) ? KR_PATTERN : NORMAL_PATTERN;
    }
    private static boolean isKorea(Locale locale) {
        return Locale.KOREA.getCountry().equals(locale.getCountry());
    }
}
