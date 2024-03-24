package commandManagers.commands;

import enums.ReadModes;
import input.JSONManager;
import interfaces.Command;

public class SaveCommand implements Command {
    public static final String USAGE = "save ИЛИ save <путь>";
    public static final String DESC = "сохранить коллекцию в файл";
    @Override
    public void execute(ReadModes readMode, String[] args) {
        String path;
        if (args.length == 0) {
            path = "test/collection.json";
        } else {
            path = args[0];
        }

        JSONManager.writeCollection(path);

        if (readMode == ReadModes.CONSOLE) {
            System.out.printf("Коллекция была сохранена в файл %s\n", path);
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
