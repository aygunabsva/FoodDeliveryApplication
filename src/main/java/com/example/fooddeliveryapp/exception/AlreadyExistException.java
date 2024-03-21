package com.example.fooddeliveryapp.exception;

public class AlreadyExistException extends RuntimeException {
    public AlreadyExistException(String ex) {
        super(ex);
    }
}
