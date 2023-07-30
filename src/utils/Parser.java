package utils;

import Exceptions.WrongModeException;
import entity.ParsedArgs;
import enums.SortMode;

import java.util.ArrayList;
import java.util.List;

import static enums.SortMode.*;

public class Parser {
    public static ParsedArgs ParseArgs(String[] args) throws WrongModeException {

        ParsedArgs parsedArgs = new ParsedArgs();

        boolean GotOutputFile = false;
        List<String> flags = new ArrayList<>();

        for (String arg: args) {
            if (arg.startsWith("-")) {
                flags.add(arg);
            } else if (!GotOutputFile) {
                parsedArgs.setOutputFile(arg);
                GotOutputFile = true;
            } else {
                parsedArgs.addInputFiles(arg);
            }
        }

        SortMode mode = Parser.ParseMode(flags);
        parsedArgs.setMode(mode);

        return parsedArgs;
    }

    public static SortMode ParseMode(List<String> flags) throws WrongModeException {
        return switch (flags.size()) {
            case 1 -> switch (flags.get(0)) {
                case "-i" -> INT_ASC;
                case "-s" -> STRING_ASC;
                default -> throw new WrongModeException("Wrong mode");
            };
            case 2 -> switch (flags.get(0) + flags.get(1)) {
                case "-i-a", "-a-i" -> INT_ASC;
                case "-i-d", "-d-i" -> INT_DESC;
                case "-s-a", "-a-s" -> STRING_ASC;
                case "-s-d", "-d-s" -> STRING_DESC;
                default -> throw new WrongModeException("Wrong mode");
            };
            default -> throw new WrongModeException("Wrong mode");
        };
    }
}
