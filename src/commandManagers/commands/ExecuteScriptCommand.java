package commandManagers.commands;

import commandManagers.CommandInvoker;
import enums.ReadModes;
import interfaces.Command;

import java.io.*;

public class ExecuteScriptCommand implements Command {
    public static final String USAGE = "execute_script <имя файла>";
    public static final String DESC = "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";

    @Override
    public void execute(ReadModes readMode, String[] args) {
        if (args.length == 1) {
            String path = args[0];
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
//                if (readMode == ReadModes.CONSOLE) {
                    CommandInvoker invoker = CommandInvoker.getInstance();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        invoker.runCommand(line, readMode);
                    }
//                } else {
//                }
            } catch (IOException e) {
//                throw new RuntimeException(e);
                System.out.println("Не удалось считать данные из файла (возможно, файл не найден)");
            }
        } else {
            System.out.printf("Неверное количество аргументов (got %s, expected 1)", args.length);
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
