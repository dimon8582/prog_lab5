package commandManagers.commands;

import enums.ReadModes;
import interfaces.Command;
import commandManagers.RouteManager;
import entity.Route;

public class UpdateIdCommand implements Command {

    private static String USAGE = "update <id> ИЛИ update <id>";
    private static String DESC = "обновить значение элемента коллекции, id которого равен заданному";
    @Override
    public void execute(ReadModes readMode) {
        RouteManager rm = RouteManager.getInstance();

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
