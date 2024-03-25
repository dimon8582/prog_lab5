package commandManagers.commands;

import Exceptions.FailedJSONReadException;
import Exceptions.FailedValidationException;
import commandManagers.RouteManager;
import entity.Route;
import enums.ReadModes;
import input.InputManager;
import input.JSONManager;
import interfaces.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class RemoveGreaterCommand implements Command {
    public static final String USAGE = "remove_greater ИЛИ remove_greater <элемент в формате .json>";
    public static final String DESC = "удалить из коллекции все элементы, превышающие заданный";
    @Override
    public void execute(ReadModes readMode, String[] args) {
        RouteManager rm = RouteManager.getInstance();
        Route inpElement;
        if (args.length == 0) {
            try {
                BufferedReader reader = InputManager.getConsoleReader();
                inpElement = RouteManager.buildNew(reader); // если с консоли
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            String path = args[0];
            try {
                inpElement = JSONManager.readElement(path);
            } catch (FailedValidationException | FailedJSONReadException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        rm.getCollection()
                .stream()
                .filter(element -> (element.compareTo(inpElement) > 0))
                .forEach(element -> rm.removeElement(element.getId()));
        if (readMode == ReadModes.CONSOLE) {
            System.out.println("Все элементы, превосходящие введённый, удалены");
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
