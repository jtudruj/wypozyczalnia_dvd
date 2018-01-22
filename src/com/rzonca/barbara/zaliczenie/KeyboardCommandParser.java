package com.rzonca.barbara.zaliczenie;
import com.rzonca.barbara.zaliczenie.constants.Command;
import com.rzonca.barbara.zaliczenie.errors.DiscException;
import com.rzonca.barbara.zaliczenie.errors.DiscExceptionType;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class KeyboardCommandParser {
    private String input;
    private String[] parameters;
    private Command command;

    public KeyboardCommandParser(String input) throws DiscException {
        this.input = input;
        parseParametersFromCommand(input);
    }

    private void parseParametersFromCommand(String text) throws DiscException {
        KeyboardCommandHandler handler = new KeyboardCommandHandler();
        List<String> splittedParameters = new ArrayList<String>(Arrays.asList(text.split(";")));
        if (splittedParameters.size() == 0) {
            throw new DiscException(DiscExceptionType.NO_PARAMETERS);
        }
        command = handler.commandFromText(splittedParameters.get(0));
        if (command == null) {
            throw new DiscException(DiscExceptionType.INVALID_COMMAND);
        }
        splittedParameters.remove(0);
        if (command.getNumberOfparameters() != splittedParameters.size()) {
            throw new DiscException(DiscExceptionType.INVALID_NUMBER_OF_PARAMETERS);
        }
        this.parameters = splittedParameters.toArray(new String[splittedParameters.size()]);
    }

    public String[] getParameters() {
        return parameters;
    }

    public Command getCommand() {
        return command;
    }
}
