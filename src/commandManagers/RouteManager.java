package commandManagers;

import Exceptions.AlreadyUsedIdException;
import builders.RouteBuilder;
import entity.Route;
import input.InputManager;
import input.JSONManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

// Receiver
public class RouteManager {
    private PriorityQueue<Route> collection;
    private static RouteManager instance;
    private static Date initializationDate;

    private RouteManager() {
        String collectionFilePath = InputManager.getCollectionFilePath();
        if (collectionFilePath == null) {
            this.collection = new PriorityQueue<>();
            System.out.println("Коллекция не была загружена из файла");
        } else {
            this.collection = JSONManager.readCollection(collectionFilePath);
            if (checkIdUniqueness()) {
                System.out.println("Коллекция была загружена из файла");
            } else {
                this.collection = new PriorityQueue<>();
                System.out.println("Ошибка при загрузке из файла: были обнаружены одинаковые id у элементов");
            }
        }
    }

    public static RouteManager getInstance() {
        if (instance == null) {
            instance = new RouteManager();
            initializationDate = new Date();
        }
        return instance;
    }

    public Date getInitializationDate() {
        return initializationDate;
    }

    public PriorityQueue<Route> getCollection() {
        return collection;
    }

    public void addElement(Route el) throws AlreadyUsedIdException{
        if (getIds().stream().allMatch(id -> id != el.getId())) {
            collection.add(el);
        } else {
            throw new AlreadyUsedIdException("Этот id уже есть в коллекции!");
        }
    }
    public void buildNew(BufferedReader reader) throws IOException {
        Route element = RouteBuilder.build(reader);
        addElement(element);
    }
    public void updateById(long id, Route el) {

    }

    public List<Long> getIds() {
        return collection.stream().map(Route::getId).collect(Collectors.toList());
    }

    public boolean checkIdUniqueness() {
        ArrayList<Long> ids = (ArrayList<Long>) getIds();
        Set<Long> idSet = new HashSet<>(ids);
        return (idSet.size() == ids.size());
    }

    public static PriorityQueue<Route> convertFrom(Route[] array) {
        PriorityQueue<Route> collection = new PriorityQueue<>();
        collection.addAll(Arrays.asList(array));
        return collection;
    }
}
