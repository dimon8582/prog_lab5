package builders;

import entity.Coordinates;
import entity.LocationFrom;
import entity.LocationTo;
import entity.Route;
import input.InputManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class RouteBuilder {
    public static Route build(BufferedReader reader) throws IOException {
        System.out.println("Создание маршрута...");

        System.out.println("Введите имя маршрута (String) > ");
        String name = reader.readLine();

        Coordinates coordinates = CoordinatesBuilder.build(reader);

        LocationFrom locFrom = LocationFromBuilder.build(reader);

        LocationTo locTo = LocationToBuilder.build(reader);

        System.out.println("Введите дистанцию маршрута (double) > ");
        double distance = Double.parseDouble(reader.readLine());

        System.out.println("Маршрут настроен");
        Route route = new Route(name, coordinates, locFrom, locTo, distance);
        return route;
    }
}
