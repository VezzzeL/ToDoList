package com.softserve.itacademy.exceptions;

public class NullEntityReferenceException extends RuntimeException{
    public NullEntityReferenceException() {
        super();
    }

    public NullEntityReferenceException(String message) {
        super(message);
    }
}
