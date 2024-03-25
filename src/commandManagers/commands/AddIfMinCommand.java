package commandManagers.commands;

import Exceptions.FailedJSONReadException;
import Exceptions.FailedValidationException;
import commandManagers.RouteManager;
import comparators.RouteComparator;
import entity.Route;
import enums.ReadModes;
import input.InputManager;
import input.JSONManager;
import interfaces.Command;

import java.io.BufferedReader;
import java.io.IOException;

public class AddIfMinCommand implements Command {
    public static final String USAGE = "add_if_min ИЛИ add_if_min <элемент в формате .json>";
    public static final String DESC = "добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции";

    @Override
    public void execute(ReadModes readMode, String[] args) {
        RouteManager rm = RouteManager.getInstance();
        Route minElement = rm.getMinElement();
        Route element;
        if (args.length == 0) {
            try {
                BufferedReader reader = InputManager.getConsoleReader();
                element = RouteManager.buildNew(reader); // если с консоли
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            String path = args[0];
            try {
                element = JSONManager.readElement(path);
            } catch (FailedValidationException | FailedJSONReadException e) {
                System.out.println(e.getMessage());
                return;
            }
        }


        if (element.compareTo(minElement) < 0) {
            if (readMode == ReadModes.CONSOLE) {
                rm.addElement(element, true);
                System.out.println("Минимальный элемент добавлен в коллекцию");
            } else {
                rm.addElement(element);
            }
        } else {
            if (readMode == ReadModes.CONSOLE) {
                System.out.println("Указанный элемент не будет самым минимальным");
            }
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
