package liang.binaryio.examples;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TestObjectOutputStream {

    public static final String PATH = "src/main/resources/";

    public static void main(String[] args) throws IOException {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(PATH + "object.dat"))) {
            output.writeUTF("John");
            output.writeDouble(95.5);
            output.writeObject(new java.util.Date());
        }
    }
}
