package commandManagers;

import commandManagers.commands.*;
import enums.ReadModes;
import input.InputManager;
import interfaces.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CommandInvoker {
    private Map<String, Command> commands;
    private static CommandInvoker instance;

    private CommandInvoker() {
        commands = new HashMap<String, Command>();

        commands.put("help", new HelpCommand());
        commands.put("add", new AddCommand());
        commands.put("info", new InfoCommand());
        commands.put("show", new ShowCommand());
        commands.put("update", new UpdateIdCommand());
        commands.put("execute_script", new ExecuteScriptCommand());
    }

    public static CommandInvoker getInstance() {
        if (instance == null) {
            instance = new CommandInvoker();
        }
        return instance;
    }

    public void listenCommands() {
        try (BufferedReader reader = InputManager.getReader(System.in)) {
            while (true) {
                String line = reader.readLine();
                String[] tokens = line.split(" ");
                Command command = commands.get(tokens[0]);
                command.execute(ReadModes.CONSOLE, Arrays.copyOfRange(tokens, 1, tokens.length));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void runCommand(String line, ReadModes readMode) {
        String[] tokens = line.split(" ");
        Command command = commands.get(tokens[0]);
        command.execute(readMode, Arrays.copyOfRange(tokens, 1, tokens.length));
    }

    public Map<String, Command> getCommands() {
        return commands;
    }
}

