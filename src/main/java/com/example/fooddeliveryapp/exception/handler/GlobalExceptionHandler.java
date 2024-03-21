package com.example.fooddeliveryapp.exception.handler;

import com.example.fooddeliveryapp.exception.AlreadyExistException;
import com.example.fooddeliveryapp.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException ex){
        log.error("NotFoundException ->  {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<String> handleNotFoundException(AlreadyExistException ex){
        log.error("AlreadyExistException ->  {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }
}
