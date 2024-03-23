package com.example.fooddeliveryapp.exception;

public class IsNotActiveException extends RuntimeException {
    public IsNotActiveException(String ex) {
        super(ex);
    }
}
