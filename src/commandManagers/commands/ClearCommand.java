package commandManagers.commands;

import commandManagers.RouteManager;
import enums.ReadModes;
import interfaces.Command;

public class ClearCommand implements Command {
    public static final String USAGE = "clear";
    public static final String DESC = "очистить коллекцию";
    @Override
    public void execute(ReadModes readMode, String[] args) {
        RouteManager rm = RouteManager.getInstance();
        rm.getCollection().clear();
        if (readMode == ReadModes.CONSOLE) {
            System.out.println("Коллекция очищена");
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
