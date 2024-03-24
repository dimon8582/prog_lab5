package commandManagers.commands;

import entity.Route;
import enums.ReadModes;
import input.InputManager;
import input.JSONManager;
import interfaces.Command;
import commandManagers.RouteManager;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AddCommand implements Command {
    private final String USAGE = "add ИЛИ add <элемент в формате .json>";
    private final String DESC = "добавить новый элемент в коллекцию";

    @Override
    public void execute(ReadModes readMode, String[] args) {
        RouteManager rm = RouteManager.getInstance();
        if (readMode == ReadModes.CONSOLE) {
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
                RouteManager.getInstance().addElement(element);
            }
            System.out.println("Добавлен элемент в коллекцию");
        } else if (readMode == ReadModes.FILE) {
//            rm.readNew(); // если с файла

        }
    }

    public String getDesc() {
        return DESC;
    }

    public String getUsage() {
        return USAGE;
    }
}
