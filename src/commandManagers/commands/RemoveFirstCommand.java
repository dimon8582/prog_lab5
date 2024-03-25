package commandManagers.commands;

import commandManagers.RouteManager;
import enums.ReadModes;
import interfaces.Command;

public class RemoveFirstCommand implements Command {
    public static final String USAGE = "remove_first";
    public static final String DESC = "удалить первый элемент из коллекции";

    @Override
    public void execute(ReadModes readMode, String[] args) {
        RouteManager rm = RouteManager.getInstance();
        rm.getCollection().remove();
        if (readMode == ReadModes.CONSOLE) {
            System.out.println("Первый элемент коллекции удалён");
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
