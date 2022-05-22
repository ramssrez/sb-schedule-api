package com.at.internship.schedule.exeption;

import com.at.internship.schedule.constants.StringConstantsErrors;
import com.at.internship.schedule.response.ErrorResponse;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
        response.setCode(StringConstantsErrors.VALIDATION_FAILED_CODE);
        response.setMessage(StringConstantsErrors.VALIDATION_FAILED_MESSAGE);
        response.setErrorMessages(errorMessages);
        return response;
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleMethodNullPointer(NullPointerException e) {
        ErrorResponse response = new ErrorResponse();
        response.setCode(StringConstantsErrors.RECORD_NOT_FOUND_CODE);
        response.setMessage(StringConstantsErrors.RECORD_NOT_FOUND_MESSAGE);
        response.setErrorMessages(Collections.singletonList(StringConstantsErrors.RECORD_NOT_FOUND_GENERAL));
        return response;
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleMethodNotFound(EmptyResultDataAccessException e){
        String errorM;
        String errorMessage = e.getMessage();
        int indexOne = errorMessage.indexOf("id");
        int indexTwo = errorMessage.indexOf(" exists");
        errorM = errorMessage.substring(indexOne,indexTwo);
        ErrorResponse response = new ErrorResponse();
        response.setCode(StringConstantsErrors.RECORD_NOT_FOUND_CODE);
        response.setMessage(StringConstantsErrors.RECORD_NOT_FOUND_MESSAGE);
        response.setErrorMessages(Collections.singletonList(String.format(StringConstantsErrors.RECORD_NOT_FOUND_ERROR,errorM)));
        return response;
    }
}
