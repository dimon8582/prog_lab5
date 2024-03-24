import commandManagers.CommandInvoker;

public class Main {
    public static void main(String[] args) {
        CommandInvoker invoker = CommandInvoker.getInstance();
        invoker.listenCommands();
    }
}

// + валидация введённых чисел в консоли
// необязательные поля чтоб файлы тоже принимали и проверку значений вставить
// остальные команды
// javadoc