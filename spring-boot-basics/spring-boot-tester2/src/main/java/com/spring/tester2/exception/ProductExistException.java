package com.spring.tester2.exception;

// RuntimeException: unchecked exception
public class ProductExistException extends RuntimeException {

    public ProductExistException(String message) {
        super(message);
    }
}
