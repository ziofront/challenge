package com.ziofront.challenge.web.controller.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiho
 */
@ControllerAdvice
@RestController
public class RestExceptionHandler {

    private static Logger LOG = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public String handleException(Exception e) {

        LOG.error("{}", e.getMessage(), e);

        return e.getMessage();
    }

}
