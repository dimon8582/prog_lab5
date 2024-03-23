package entity;

public class Coordinates {
    private double x; //Максимальное значение поля: 790
    private Integer y; //Значение поля должно быть больше -858, Поле не может быть null

    public Coordinates(double x, Integer y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
