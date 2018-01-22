package com.rzonca.barbara.zaliczenie.errors;

public enum DiscExceptionType {
    INVALID_COMMAND("Invalid command"),
    NO_COMMAND("No command"),
    INVALID_NUMBER_OF_PARAMETERS("Invalid number of parameters for command"),
    NO_PARAMETERS("No parameters after command");

    private final String message;

    private DiscExceptionType(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "KeyboardCommandException: " + message;
    }
}
