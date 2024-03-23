package commandManagers.commands;

import commandManagers.CommandInvoker;
import enums.ReadModes;
import interfaces.Command;
import commandManagers.RouteManager;

import java.util.Map;

public class HelpCommand implements Command {
    private static String USAGE = "help";
    private static String DESC = "вывести справку по доступным командам";
    @Override
    public void execute(ReadModes readMode) {
        if (readMode == ReadModes.CONSOLE) {
            Map<String, Command> commands = CommandInvoker.getInstance().getCommands();

            for (Command command : commands.values()) {
                System.out.printf("%s - %s\n",command.getUsage(), command.getDesc());
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
