package commandManagers.commands;

import enums.ReadModes;
import interfaces.Command;

public class ExitCommand implements Command {
    public static final String USAGE = "exit";
    public static final String DESC = "завершить программу (без сохранения в файл)";

    @Override
    public void execute(ReadModes readMode, String[] args) {
        System.exit(0);
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
