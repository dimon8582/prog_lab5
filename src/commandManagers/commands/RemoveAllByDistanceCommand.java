package commandManagers.commands;

import commandManagers.RouteManager;
import enums.ReadModes;
import interfaces.Command;

public class RemoveAllByDistanceCommand implements Command {
    private final String USAGE = "remove_all_by_distance <дистанция(double)>";
    private final String DESC = "удалить из коллекции все элементы, значение поля distance которого эквивалентно заданному";


    @Override
    public void execute(ReadModes readMode, String[] args) {
        RouteManager rm = RouteManager.getInstance();
        if (args.length == 1) {
            double distance;
            try {
                distance = Double.parseDouble(args[0]);
                rm.removeAllByDistance(distance);
                if (readMode == ReadModes.CONSOLE) {
                    System.out.printf("Все элементы с дистанцией %s удалены\n", distance);
                }
            } catch (NumberFormatException e) {
                System.out.println("Некорректная дистанция");
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
