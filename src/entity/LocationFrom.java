package entity;

public class LocationFrom {
    private int x;
    private Integer y; //Поле не может быть null
    private float z;

    public LocationFrom(int x, Integer y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static boolean checkX(int x) {
        return true;
    }

    public static boolean checkY(Integer y) {
        return (y != null);
    }
    public static boolean checkZ(float z) {
        return true;
    }

    @Override
    public String toString() {
        return "LocationFrom{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
