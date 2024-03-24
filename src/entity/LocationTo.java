package entity;

public class LocationTo {
    private float x;
    private Integer y; //Поле не может быть null
    private long z;
    private String name; //Длина строки не должна быть больше 443, Поле не может быть null

    public LocationTo(String name, float x, Integer y, long z) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public static boolean checkX(float x) {
        return true;
    }
    public static boolean checkY(Integer y) {
        return (y != null);
    }
    public static boolean checkZ(long z) {
        return true;
    }
    public static boolean checkName(String name) {
        return (name != null && name.length() <= 443);
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
