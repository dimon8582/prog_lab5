package builders;

import entity.LocationFrom;
import entity.LocationTo;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class LocationToBuilder {
    public static LocationTo build(BufferedReader reader) throws IOException {
        System.out.println("Настройка окончательной локации...");

        System.out.println("Введите имя окончательной локации (String) > ");
        String name = reader.readLine();

        System.out.println("Введите x (float) > ");
        float x = Float.parseFloat(reader.readLine());

        System.out.println("Введите y (Integer) > ");
        Integer y = Integer.parseInt(reader.readLine());

        System.out.println("Введите z (long) > ");
        long z = Long.parseLong(reader.readLine());

        System.out.println("Окончательная локация настроена");
        return new LocationTo(name, x, y, z);
    }
}
