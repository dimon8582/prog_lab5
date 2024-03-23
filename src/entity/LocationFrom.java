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

    @Override
    public String toString() {
        return "LocationFrom{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
