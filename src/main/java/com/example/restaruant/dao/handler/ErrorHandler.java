package com.example.restaruant.dao.handler;

import com.example.restaruant.model.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RuntimeException.class)
    private ExceptionDto handler(RuntimeException runtimeException) {
        return new ExceptionDto(runtimeException.getMessage());

    }

}
