package com.at.internship.schedule.exception;

import com.at.internship.schedule.response.ErrorResponse;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ErrorResponse handleDefaultHandlerExceptionResolver(HttpMessageNotReadableException e){
        e.printStackTrace();
        return new ErrorResponse();
    }
}
