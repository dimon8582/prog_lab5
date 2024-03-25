package commandManagers.commands;

import entity.Route;
import enums.ReadModes;
import interfaces.Command;
import commandManagers.RouteManager;

import java.util.PriorityQueue;

public class ShowCommand implements Command {
    private static String USAGE = "show";
    private static String DESC = "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";

    @Override
    public void execute(ReadModes readMode, String[] args) {
        if (readMode == ReadModes.CONSOLE) {
            RouteManager rm = RouteManager.getInstance();
            PriorityQueue<Route> collection = rm.getCollection();
            RouteManager.printCollection(collection);
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
