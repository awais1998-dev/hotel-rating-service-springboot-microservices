package com.tech.hotel_service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionalHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<HashMap<String, String>> handleResourceNotFoundException(ResourceNotFoundException ex){
        HashMap<String, String> map = new HashMap<>();
        map.put("message", ex.getMessage());
        return new ResponseEntity<HashMap<String, String>>(map, HttpStatus.NOT_FOUND);
    }
}
