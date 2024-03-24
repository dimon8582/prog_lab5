package input;

import java.io.*;

public class InputManager {
    private static BufferedReader consoleReader;

//    public static BufferedReader getReader(InputStream inputStream) {
//        return new BufferedReader(new InputStreamReader(inputStream));
//    }

    public static BufferedReader getConsoleReader() {
        if (consoleReader == null) {
            consoleReader = new BufferedReader(new InputStreamReader(System.in));
        }
        return consoleReader;
    }

    public static BufferedReader getFileReader(String path) {
        try {
            return new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void write(String path, String data) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)))) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
