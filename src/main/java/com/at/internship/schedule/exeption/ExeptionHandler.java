package com.at.internship.schedule.exeption;

import com.at.internship.schedule.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExeptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        final List<String> errorMessages = new ArrayList<>();
        e.getBindingResult().getAllErrors().forEach(err -> {
            if(!(err instanceof FieldError)) return;
            FieldError fieldError = (FieldError) err;
            errorMessages.add(fieldError.getDefaultMessage());
        });
        ErrorResponse response = new ErrorResponse();
        response.setTimestamp(LocalDateTime.now());
        response.setCode("VALIDATION_FAILED");
        response.setMessage("There were validation errors");
        response.setErrorMessages(errorMessages);
        return response;
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleMethodNullPointer(NullPointerException e) {
        final List<String> errorMessages = new ArrayList<>();
        errorMessages.add("Requested Not found");
        ErrorResponse response = new ErrorResponse();
        response.setTimestamp(LocalDateTime.now());
        response.setCode("RECORD_NOT_FOUND");
        response.setMessage("Record not found");
        response.setErrorMessages(errorMessages);
        return response;
    }
}
