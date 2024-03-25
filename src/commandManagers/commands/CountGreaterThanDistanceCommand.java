package commandManagers.commands;

import commandManagers.RouteManager;
import enums.ReadModes;
import interfaces.Command;

public class CountGreaterThanDistanceCommand implements Command {
    private final String USAGE = "count_greater_than_distance <дистанция(double>";
    private final String DESC = "вывести количество элементов, значение поля distance которых больше заданного";

    @Override
    public void execute(ReadModes readMode, String[] args) {
        RouteManager rm = RouteManager.getInstance();
        if (args.length == 1) {
            double distance;
            try {
                distance = Double.parseDouble(args[0]);
                System.out.printf("Количество элементов с дистанцией выше введённой: %s\n", rm.countGreaterThanDistance(distance));
            } catch (NumberFormatException e) {
                System.out.printf("Некорректные аргументы: использование: %s\n", USAGE);
            }
        } else {
            System.out.printf("Некорректные аргументы, использование: %s\n", USAGE);
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
