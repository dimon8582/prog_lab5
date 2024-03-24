package input;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import commandManagers.RouteManager;
import entity.Route;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class JSONManager {
    public static Route readElement(String path) {
        Gson gson = new Gson();
        try {
            Route element = gson.fromJson(new InputStreamReader(new FileInputStream(path)), Route.class);
            return element;
        } catch (FileNotFoundException e) {
            System.out.println("Не удалось считать из файла json");
        }
        return null;
    }

    public static void writeElement(String path, Route element) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(element);
        InputManager.write(path, json);
    }

    public static void writeCollection(String path) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        PriorityQueue<Route> collection = RouteManager.getInstance().getCollection();
        String json = gson.toJson(collection);
        InputManager.write(path, json);
    }

    public static PriorityQueue<Route> readCollection(String path) throws RuntimeException{
        Gson gson = new Gson();
        Route[] arrayCollection;
        try {
            arrayCollection = gson.fromJson(new InputStreamReader(new FileInputStream(path)), Route[].class);
            return RouteManager.convertFrom(arrayCollection);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Файл не найден");
        }
    }
}
