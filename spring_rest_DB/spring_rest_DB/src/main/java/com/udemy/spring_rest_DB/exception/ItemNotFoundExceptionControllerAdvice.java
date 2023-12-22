package com.udemy.spring_rest_DB.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ItemNotFoundExceptionControllerAdvice {
    @ResponseBody
    @ExceptionHandler(ItemNotFountException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String itemNotFoundHandler(ItemNotFountException ex){
        return ex.getMessage();
    }
}
