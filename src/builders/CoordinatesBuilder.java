package builders;

import entity.Coordinates;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class CoordinatesBuilder {
    public static Coordinates build(BufferedReader reader) throws IOException {

        System.out.println("Настройка координат...");

        System.out.println("Введите x (double) > ");
        double x = Double.parseDouble(reader.readLine());

        System.out.println("Введите y (Integer) > ");
        Integer y = Integer.parseInt(reader.readLine());

        System.out.println("Координаты настроены");
        return new Coordinates(x, y);
    }
}
