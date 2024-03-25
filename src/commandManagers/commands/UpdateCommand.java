package commandManagers.commands;

import Exceptions.FailedJSONReadException;
import Exceptions.FailedValidationException;
import entity.Route;
import enums.ReadModes;
import input.InputManager;
import input.JSONManager;
import interfaces.Command;
import commandManagers.RouteManager;

import java.io.BufferedReader;
import java.io.IOException;

public class UpdateCommand implements Command {

    private static String USAGE = "update ИЛИ update <элемент в формате .json>";
    private static String DESC = "обновить значение элемента коллекции, id которого равен заданному";

    @Override
    public void execute(ReadModes readMode, String[] args) {
        RouteManager rm = RouteManager.getInstance();
        if (args.length == 0) {
            try {
                BufferedReader reader = InputManager.getConsoleReader();
                Route element = RouteManager.buildNew(reader, true);
                if (readMode == ReadModes.CONSOLE) {
                    rm.update(element, true); // если с консоли, уже отвалидировано
                } else {
                    System.out.printf("Некорректные аргументы, использование: %s\n", USAGE);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            // из файла .json
            String path = args[0];
            try {
                Route element = JSONManager.readElement(path);
                rm.update(element);
            } catch (FailedValidationException | FailedJSONReadException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        if (readMode == ReadModes.CONSOLE) {
            System.out.println("Обновлён элемент в коллекции");
        }
    }


    @Override
    public String getDesc() {
        return DESC;
    }

    @Override
    public String getUsage() {
        return USAGE;
    }

}
