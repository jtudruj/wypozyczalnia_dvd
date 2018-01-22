package com.rzonca.barbara.zaliczenie.constants;

public enum Command {
    ADD(4, "D", "<id/tytuł>;<pożyczył>;<data pożyczenia>;<informacje dodatkowe>"),
    REMOVE(1, "U", "<id/tytuł>"),
    LIST(0, "L", null),
    FILTERED_LIST(1, "LF", "<tekst>"),
    ORDERED_LIST(1, "S", "<kolumna>"),
    EXPORT_TO_FILE(1, "W", "<ścieżka do pliku>"),
    IMPORT_FROM_FILE(1, "R", "<ścieżka do pliku>"),
    QUIT(0, "QUIT", null),
    HELP(0, "HELP", null);

    private final Integer numberOfparameters;
    private final String symbol;
    private final String parameters;

    private Command(Integer numberOfparameters, String symbol, String parameters) {
        this.numberOfparameters = numberOfparameters;
        this.symbol = symbol;
        this.parameters = parameters;
    }

    public Integer getNumberOfparameters() {
        return numberOfparameters;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getParameters() {
        if (parameters == null) {
            return "";
        }
        return parameters;
    }
}
