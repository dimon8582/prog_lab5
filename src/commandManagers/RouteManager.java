package commandManagers;

import builders.RouteBuilder;
import entity.Route;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;
import java.util.PriorityQueue;

// Receiver
public class RouteManager {
    private PriorityQueue<Route> collection;
    private static RouteManager instance;
    private static Date initializationDate;

    private RouteManager() {
        collection = new PriorityQueue<>();
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

    public void addElement(Route el) {
        collection.add(el);
    }
    public void buildNew(BufferedReader reader) throws IOException {
        Route element = RouteBuilder.build(reader);
        addElement(element);
    }
    public void updateById(long id, Route el) {

    }
}
