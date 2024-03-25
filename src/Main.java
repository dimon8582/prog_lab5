import commandManagers.CommandInvoker;

public class Main {
    public static void main(String[] args) {
        CommandInvoker invoker = CommandInvoker.getInstance();
        invoker.listenCommands();
    }
}

// ctrl + d че делать то будем с этим?
// javadoc