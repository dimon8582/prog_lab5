import commandManagers.CommandInvoker;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CommandInvoker invoker = CommandInvoker.getInstance();
        invoker.listenCommands();

        // пример для теории
//        List<Animal> animalList = new ArrayList<>();
////        animalList.add(new Object());
//        Cat cat = (Cat) animalList.get(0);
//        System.out.println(cat.meow());
//
//        List<Object> obj = new ArrayList<>();
//        obj.add(new Animal());
    }
}

// пример для теории
//class Animal {
//    String name;
//}
//
//class Cat extends Animal{
//    public String meow(){
//        return "Meow";
//    }
//}