package com.rzonca.barbara.zaliczenie.constants;

public final class Resources {
    public static final String COMUNICATE_HELP = "Lista dostępnych komend:\n"
            + "Dodawanie płyty: " + Command.ADD.getSymbol() + ";" + Command.ADD.getParameters() + "\n"
            + "Usunięcie płyty:" + Command.REMOVE.getSymbol() + ";" + Command.REMOVE.getParameters() + "\n"
            + "Wyświetlenie listy płyt: " + Command.LIST.getSymbol() + ";" + Command.LIST.getParameters() + "\n"
            + "Ustawienie sortowania listy płyt według wybranej kolumny: " + Command.ORDERED_LIST.getSymbol() + ";" + Command.ORDERED_LIST.getParameters() + "\n"
            + "Zapis danych do pliku tekstowego: " + Command.EXPORT_TO_FILE.getSymbol() + ";" + Command.EXPORT_TO_FILE.getParameters() + "\n"
            + "Odczyt danych z pliku tekstowego: " + Command.IMPORT_FROM_FILE.getSymbol() + ";" + Command.IMPORT_FROM_FILE.getParameters() + "\n"
            + "Wymuszenie zakończenia przetwarzania (wyjście): " + Command.QUIT.getSymbol() + ";" + Command.QUIT.getParameters() + "\n";

    public static final String WELCOME = "Podaj komendę i parametry.\nWpisz \"" + Command.HELP.getSymbol() + "\" aby wyświetlić listę dostępnych komend";
    public static final String GOOD_BYE = "Program zakończył pracę.";
}
