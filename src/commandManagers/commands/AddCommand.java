package commandManagers.commands;

import enums.ReadModes;
import input.InputManager;
import interfaces.Command;
import commandManagers.RouteManager;

import java.io.BufferedReader;
import java.io.IOException;

public class AddCommand implements Command {
    private final String USAGE = "add ИЛИ add <элемент>";
    private final String DESC = "добавить новый элемент в коллекцию";

    @Override
    public void execute(ReadModes readMode, String[] args) {
        RouteManager rm = RouteManager.getInstance();
        if (readMode == ReadModes.CONSOLE) {
            try (BufferedReader reader = InputManager.getReader(System.in)) {
                rm.buildNew(reader); // если с консоли
            } catch (IOException e) {
                throw new RuntimeException(e);
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
