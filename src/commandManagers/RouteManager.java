package commandManagers;

import Exceptions.FailedValidationException;
import builders.RouteBuilder;
import entity.Coordinates;
import entity.LocationFrom;
import entity.LocationTo;
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

    public void addElement(Route el) throws FailedValidationException {
        addElement(el, false);
    }

    public void addElement(Route el, boolean skipValidations) throws FailedValidationException {
        if (skipValidations) {
            collection.add(el);
        } else {
            if (RouteManager.validateElement(el)) {
                collection.add(el);
            } else {
                throw new FailedValidationException("Ошибка в валидации");
            }
        }
    }

    public void buildNew(BufferedReader reader) throws IOException {
        Route element = RouteBuilder.build(reader);
        addElement(element);
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

    public static boolean validateElement(Route el, boolean skipId) {
        if (!skipId) {
            if (!Route.checkId(el.getId())) {
                System.out.println("Неверный id (возможно, он уже занят)");
                return false;
            }
        }

        if (!Route.checkName(el.getName())) {
            System.out.println("Неверное имя элемента (Поле не может быть null, Строка не может быть пустой)");
            return false;
        }

        if (!Route.checkCreationDate(el.getCreationDate())) {
            System.out.println("Неверная дата создания (Поле не может быть null)");
            return false;
        }

        Coordinates coordinates = el.getCoordinates();
        if (!Route.checkCoordinates(coordinates)) {
            System.out.println("Некорректные координаты (Поле не может быть null)");
            return false;
        }
        if (!Coordinates.checkX(coordinates.getX()) || !Coordinates.checkY(coordinates.getY())) {
            System.out.println("Некорректные координаты (x: Максимальное значение поля: 790, y: Значение поля должно быть больше -858, Поле не может быть null");
            return false;
        }

        LocationFrom from = el.getFrom();
        if (!Route.checkFrom(from)) {
            System.out.println("Некорректная изначальная локация (Поле не может быть null)");
            return false;
        }
        if (!LocationFrom.checkY(from.getY())) {
            System.out.println("Некорректная изначальная локация (y: Поле не может быть null");
            return false;
        }

        LocationTo to = el.getTo();
        if (to != null) {
            if (!LocationTo.checkY(to.getY()) || !LocationTo.checkName(to.getName())) {
                System.out.println("Некорректная окончательная локация (y: Поле не может быть null, name: Длина строки не должна быть больше 443, Поле не может быть null)");
                return false;
            }
        }

        if (!Route.checkDistance(el.getDistance())) {
            System.out.println("Некорректная дистанция (Значение поля должно быть больше 1)");
            return false;
        }

        return true;
    }

    public static boolean validateElement(Route el) {
        return validateElement(el, false);
    }
}
