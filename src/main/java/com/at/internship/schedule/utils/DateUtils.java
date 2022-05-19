package com.at.internship.schedule.utils;

import com.at.internship.schedule.constants.StringConstants;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateUtils {
    public String formatDefault(LocalDateTime dateTime) {
        if(dateTime == null) return null;
        return dateTime.format(DateTimeFormatter.ofPattern(StringConstants.FORMAT_DATETIME_DEFAULT));
    }

    public String formatDefault(LocalDate date) {
        if(date == null) return null;
        return date.format(DateTimeFormatter.ofPattern(StringConstants.FORMAT_DATE_DEFAULT));
    }

    public LocalDate parseDefaultDate(String date) {
        if(date == null) return null;
        return LocalDate.parse(date,DateTimeFormatter.ofPattern(StringConstants.FORMAT_DATE_DEFAULT));
    }

    public LocalDateTime parseDefaultDateTime(String datetime) {
        if(datetime == null) return null;
        return LocalDateTime.parse(datetime,DateTimeFormatter.ofPattern(StringConstants.FORMAT_DATETIME_DEFAULT));
    }
}
