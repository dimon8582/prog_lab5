package util;

public class IdManager {
    private static long currentUsedId;
    public static long getId() {
        return currentUsedId++;
    }
}
