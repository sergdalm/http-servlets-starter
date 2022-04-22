package com.sergdalm.http.util;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@UtilityClass
public class LocalDateFormatter {
    private static final String PATTERN = "yyyy-MM-dd";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(PATTERN);

    public LocalDate format(String data) {
        return LocalDate.parse(data, FORMATTER);
    }

    public boolean isValid(String date) {
        try {
            format(date);
            return true;
        } catch (DateTimeParseException exception) {
            return false;
        }
    }

}
