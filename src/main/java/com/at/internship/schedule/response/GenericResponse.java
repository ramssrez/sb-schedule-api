package com.at.internship.schedule.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GenericResponse <T>{
    private LocalDateTime timestamp;
    private String code;
    private String message;
    private T content;

    public GenericResponse() {
        timestamp = LocalDateTime.now();
    }
}
