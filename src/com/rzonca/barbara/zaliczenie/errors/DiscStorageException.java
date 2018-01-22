package com.rzonca.barbara.zaliczenie.errors;

public class DiscStorageException extends Exception {

    public DiscStorageException(DiscStorageExceptionType exceptionType) {
        this(exceptionType.toString());
    }

    private DiscStorageException (String message) {
        super(message);
    }

    public String getMessage() {
        return super.getMessage();
    }
}
