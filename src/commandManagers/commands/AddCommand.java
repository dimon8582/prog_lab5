package commandManagers.commands;

import Exceptions.FailedValidationException;
import entity.Route;
import enums.ReadModes;
import input.InputManager;
import input.JSONManager;
import interfaces.Command;
import commandManagers.RouteManager;

import java.io.BufferedReader;
import java.io.IOException;

public class AddCommand implements Command {
    private final String USAGE = "add ИЛИ add <элемент в формате .json>";
    private final String DESC = "добавить новый элемент в коллекцию";

    @Override
    public void execute(ReadModes readMode, String[] args) {
        RouteManager rm = RouteManager.getInstance();
        if (args.length == 0) {
            try {
                BufferedReader reader = InputManager.getConsoleReader();
                rm.buildNew(reader); // если с консоли
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            // из файла .json
            String path = args[0];
            Route element = JSONManager.readElement(path);
            try {
                RouteManager.getInstance().addElement(element);
            } catch (FailedValidationException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        if (readMode == ReadModes.CONSOLE) {
            System.out.println("Добавлен элемент в коллекцию");
        }
    }

    public String getDesc() {
        return DESC;
    }

    public String getUsage() {
        return USAGE;
    }
}
