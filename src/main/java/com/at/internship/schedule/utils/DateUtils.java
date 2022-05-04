package com.at.internship.schedule.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateUtils {

    public String formatDefault(LocalDateTime dateTime) {
        String defaultDateTimeFormat = "MM/dd/yyyy hh:mm:ss";
        if(dateTime == null) return null;
        return dateTime.format(DateTimeFormatter.ofPattern(defaultDateTimeFormat));
    }

    public String formatDefault(LocalDate date) {
        String defaultDateFormat = "MM/dd/yyyy";
        if(date == null) return null;
        return date.format(DateTimeFormatter.ofPattern(defaultDateFormat));
    }

}
