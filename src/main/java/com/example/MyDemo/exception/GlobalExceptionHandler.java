package com.example.MyDemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.util.NoSuchElementException;
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RestrictedIfoException.class)
    public ResponseEntity<String> RestrictedInfoExceptionErorr(RestrictedIfoException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST );
    }
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String>  noSuchElementEroor(){
        return new ResponseEntity<>("no such element has found", HttpStatus.CONFLICT);
    }
}
