package com.at.internship.schedule.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateUtils {
    private final String defaultDateTimeFormat = "MM/dd/yyyy hh:mm:ss";
    private final String defaultDateFormat = "MM/dd/yyyy";

    public String formatDefault(LocalDateTime dateTime) {
        if(dateTime == null) return null;
        return dateTime.format(DateTimeFormatter.ofPattern(defaultDateTimeFormat));
    }

    public String formatDefault(LocalDate date) {
        if(date == null) return null;
        return date.format(DateTimeFormatter.ofPattern(defaultDateFormat));
    }

}
