package commandManagers;

import Exceptions.AlreadyUsedIdException;
import builders.RouteBuilder;
import entity.Route;
import input.InputManager;
import input.JSONManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.PriorityQueue;
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
        } else {
            this.collection = JSONManager.readCollection(collectionFilePath);
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

    public static PriorityQueue<Route> convertFrom(Route[] array) {
        PriorityQueue<Route> collection = new PriorityQueue<>();
        collection.addAll(Arrays.asList(array));
        return collection;
    }
}
