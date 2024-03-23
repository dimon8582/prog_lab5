package entity;

public class LocationTo {
    private float x; //Поле не может быть null
    private Integer y; //Поле не может быть null
    private long z;
    private String name; //Длина строки не должна быть больше 443, Поле не может быть null

    public LocationTo(String name, float x, Integer y, long z) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "LocationTo{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", name='" + name + '\'' +
                '}';
    }
}
