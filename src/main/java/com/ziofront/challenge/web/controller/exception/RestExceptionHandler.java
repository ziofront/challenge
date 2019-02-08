package com.ziofront.challenge.web.controller.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class RestExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public String handleException(Exception e) {
        return e.getMessage();
    }

}
