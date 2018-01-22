package com.rzonca.barbara.zaliczenie;

import com.rzonca.barbara.zaliczenie.constants.Command;
import com.rzonca.barbara.zaliczenie.errors.DiscException;
import com.rzonca.barbara.zaliczenie.errors.DiscExceptionType;

public class KeyboardCommandHandler {

    public Command commandFromText(String text) throws DiscException {
        if (text == null || text.equals("")) {
            throw new DiscException(DiscExceptionType.NO_COMMAND);
        }

        switch (text.toUpperCase()) {
            case "D":
                return Command.ADD;
            case "U":
                return Command.REMOVE;
            case "L":
                return Command.LIST;
            case "LF":
                return Command.FILTERED_LIST;
            case "S":
                return Command.ORDERED_LIST;
            case "W":
                return Command.EXPORT_TO_FILE;
            case "R":
                return Command.IMPORT_FROM_FILE;
            case "QUIT":
                return Command.QUIT;
            case "HELP":
                    return Command.HELP;
            default:
                throw new DiscException(DiscExceptionType.INVALID_COMMAND);
        }
    }
}
