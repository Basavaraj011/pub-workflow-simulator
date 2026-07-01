package com.example.pub.exception;

public class RetriableActivityException extends RuntimeException {

    public RetriableActivityException(String message, Throwable cause) {
        super(message, cause);
    }
}
