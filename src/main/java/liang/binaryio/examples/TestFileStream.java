package liang.binaryio.examples;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileStream {

    public static final String PATH = "src/main/resources/";

    public static void main(String[] args) throws IOException {

        try (
                FileOutputStream output = new FileOutputStream(PATH + "temp.dat")
        ) {
            for (int i = 1; i <= 10; i++) {
                output.write(i);
            }
        }

        try (
                FileInputStream input = new FileInputStream(PATH + "temp.dat");
        ) {
            int value;
            while ((value = input.read()) != -1) {
                System.out.print(value + " ");
            }
        }
    }
}
