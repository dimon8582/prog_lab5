import commandManagers.CommandInvoker;

public class Main {
    public static void main(String[] args) {
        CommandInvoker invoker = CommandInvoker.getInstance();
        invoker.listenCommands();
    }
}

// для считывания 2 режима: для файла и~ для консоли
// валидация введённых чисел в консоли
// + execute script
// в add и других вместо {element} сделать элементы через запятую или файлом
// остальные команды
