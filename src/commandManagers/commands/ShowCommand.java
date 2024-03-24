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
            if (collection.isEmpty()) {
                System.out.println("Коллекция пуста!");
            } else {
                for (int i = 0; i < collection.size(); i++) {
                    System.out.printf("Элемент %s / %s:\n%s\n", i + 1, collection.size(), collection.toArray()[i]);
                }
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
