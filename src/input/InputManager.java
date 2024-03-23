package input;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputManager {
    public static BufferedReader getReader(InputStream inputStream) {
        return new BufferedReader(new InputStreamReader(inputStream));
    }
}
