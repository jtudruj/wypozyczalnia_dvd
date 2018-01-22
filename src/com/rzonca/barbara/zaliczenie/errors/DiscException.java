package com.rzonca.barbara.zaliczenie.errors;

public class DiscException extends Exception {

    public DiscException(DiscExceptionType exceptionType) {
        this(exceptionType.toString());
    }

    private DiscException(String message) {
        super(message);
    }

    public String getMessage() {
        return super.getMessage();
    }
}
