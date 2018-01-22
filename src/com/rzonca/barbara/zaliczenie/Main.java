package com.rzonca.barbara.zaliczenie;

import com.rzonca.barbara.zaliczenie.model.DiscModel;
import com.rzonca.barbara.zaliczenie.constants.Command;
import com.rzonca.barbara.zaliczenie.constants.Resources;
import com.rzonca.barbara.zaliczenie.controller.DiscController;
import com.rzonca.barbara.zaliczenie.errors.DiscStorageException;
import com.rzonca.barbara.zaliczenie.errors.DiscException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static void main(String[] args){
        getKeyboardCommand();
    }

    public static void getKeyboardCommand() {
        print("#####\n");
        print(Resources.WELCOME);

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine();
            try {
                KeyboardCommandParser parser = new KeyboardCommandParser(input);
                executeCommandWithParameters(parser.getCommand(), parser.getParameters());
            } catch (DiscException e) {
                printException(e);
                getKeyboardCommand();
            }
        } catch (IOException e) {
            printException(e);
        }
    }

    public static void executeCommandWithParameters(Command command, String[] parameters) {
        DiscController controller = new DiscController();
        switch (command) {

            case ADD:
                start( () -> controller.add(new DiscModel(parameters)) );
                break;
            case REMOVE:
                start( () -> controller.removeItemTitled(parameters[0]) );
                break;
            case LIST:
                start( () -> printList(controller.getList() ) );
                break;
            case FILTERED_LIST:
                start( () -> printList(controller.getListFilteredByText(parameters[0])) );
                break;
            case ORDERED_LIST:
                start( () ->  printList(controller.getListOrderedByColumn(parameters[0])) );
                break;
            case EXPORT_TO_FILE:
                start( () ->  controller.exportListToFileWithDirectory(parameters[0]) );
                break;
            case IMPORT_FROM_FILE:
                start( () -> controller.importListFromFileAtDirectory(parameters[0]) );
                break;
            case QUIT:
                print(Resources.GOOD_BYE);
                break;
            case HELP:
                print(Resources.COMUNICATE_HELP);
                getKeyboardCommand();
                break;
        }
    }

    static void start(DiscActionInterface lambda) {
        try {
            lambda.start();
        } catch (Exception e) {
            printException(e);
        } finally {
            getKeyboardCommand();
        }
    }

    static void print(String txt) {
        System.out.println(txt);
    }

    static void printException(Exception exception) {
        print("#####\n");
        print("Wystąpił błąd:");
        print(exception.getMessage());
        print("#####\n");
    }

    static void printList(List<DiscModel> list) {
        Integer longestTitle = "Tytuł".length();
        Integer longestName = "Wypożyczający".length();
        Integer longestInfo = "Dodatkowe info".length();

        for (DiscModel model: list) {
            if (model.getTitle().length() > longestTitle) {
                longestTitle = model.getTitle().length();
            }
            if (model.getLender().length() > longestName) {
                longestName = model.getLender().length();
            }
            if (model.getAdditionalInfo().length() > longestInfo) {
                longestInfo = model.getAdditionalInfo().length();
            }
        }


        String headers = "| " + fixedLengthString("Tytuł", longestTitle) + " | " + fixedLengthString("Wypożyczający", longestName) + " | " + fixedLengthString("Data", 10) + " | " + fixedLengthString("Dodatkowe info", longestInfo) + " |";

        String separator = "";
        String headersSeparator = "";
        for (int i = 0; i<headers.length(); i++) {
            separator += "-";
            headersSeparator += "=";
        }

        print(separator);
        print(headers);
        print(headersSeparator);

        for (DiscModel model: list) {
            print("| " + fixedLengthString(model.getTitle(), longestTitle) + " | " + fixedLengthString(model.getLender(), longestName) + " | " + fixedLengthString(model.getLendDate(), 10) + " | " + fixedLengthString(model.getAdditionalInfo(), longestInfo) + " |");
            print(separator);
        }
    }

    public static String fixedLengthString(String string, int length) {
        return String.format("%1$"+length+ "s", string);
    }

}

interface DiscActionInterface {
    public void start() throws Exception;
}