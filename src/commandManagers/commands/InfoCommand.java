package commandManagers.commands;

import entity.Route;
import enums.ReadModes;
import interfaces.Command;
import commandManagers.RouteManager;

import java.util.PriorityQueue;

public class InfoCommand implements Command {
    private static String USAGE = "info";
    private static String DESC = "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";

    @Override
    public void execute(ReadModes readMode, String[] args) {
        RouteManager rm = RouteManager.getInstance();
        PriorityQueue<Route> collection = rm.getCollection();
        System.out.printf("Тип коллекции: %s\n", collection.getClass().getName());
        System.out.printf("Дата создания: %s\n", rm.getInitializationDate());
        System.out.printf("Количество элементов: %s\n", collection.size());
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
