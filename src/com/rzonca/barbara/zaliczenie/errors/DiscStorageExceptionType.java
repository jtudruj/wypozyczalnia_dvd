package com.rzonca.barbara.zaliczenie.errors;

public enum DiscStorageExceptionType {
    LIST_EMPTY("Lista jest pusta"),
    FILTERED_LIST_EMPTY("Lista nie zawiera dysku z podaną frazą"),
    INVALID_COLUMN_NUMBER("Nieprawidłowy numer kolumny. Podaj numer 1, 2 lub 3."),
    INVALID_COLUMN_TYPE("Nieprawidłowy typ zmiennej. Zmienna powina być liczbą całkowitą"),
    REMOVE_ERROR_LIST_NO_CONTAINS("Lista nie posiada takiego elementu.");

    private final String message;

    private DiscStorageExceptionType(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "KeyboardCommandException: " + message;
    }
}
