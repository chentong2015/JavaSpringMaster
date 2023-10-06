package com.example.aop.exception;

public class MyApplicationException extends Exception {

    public MyApplicationException() {
    }

    public MyApplicationException(String message) {
        super(message);
    }

    public MyApplicationException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
