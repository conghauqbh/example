package com.company.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.ServletRequest;

@ControllerAdvice(annotations = Controller.class)
public class GlobalControllerAdvice {

    private static final String ERROR_400_PAGE = "error/400";

    @ExceptionHandler(value = {RuntimeException.class, Exception.class})
    public String handleRuntimeError(Exception e, ServletRequest request) {
        return ERROR_400_PAGE;
    }
}
