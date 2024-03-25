package commandManagers.commands;

import commandManagers.RouteManager;
import comparators.RouteComparator;
import entity.Route;
import enums.ReadModes;
import interfaces.Command;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class PrintDescendingCommand implements Command {
    private final String USAGE = "print_descending";
    private final String DESC = "вывести элементы коллекции в порядке убывания";

    @Override
    public void execute(ReadModes readMode, String[] args) {
        RouteManager rm = RouteManager.getInstance();
        rm.printDescending();
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
