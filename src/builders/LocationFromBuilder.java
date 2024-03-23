package builders;

import entity.Coordinates;
import entity.LocationFrom;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class LocationFromBuilder {
    public static LocationFrom build(BufferedReader reader) throws IOException {
        System.out.println("Настройка изначальной локации...");

        System.out.println("Введите x (int) > ");
        int x = Integer.parseInt(reader.readLine());

        System.out.println("Введите y (Integer) > ");
        Integer y = Integer.parseInt(reader.readLine());

        System.out.println("Введите z (float) > ");
        float z = Float.parseFloat(reader.readLine());

        System.out.println("Изначальная локация настроена");
        return new LocationFrom(x, y, z);
    }
}
