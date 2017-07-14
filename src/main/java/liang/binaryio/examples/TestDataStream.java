package liang.binaryio.examples;

import java.io.*;

public class TestDataStream {

    public static final String PATH = "src/main/resources/";

    public static void main(String[] args) throws IOException {

        try (DataOutputStream output = new DataOutputStream(new FileOutputStream(PATH + "temp.dat"))) {
            output.writeUTF("John");
            output.writeDouble(85.5);
            output.writeUTF("Jim");
            output.writeDouble(185.5);
            output.writeUTF("George");
            output.writeDouble(105.25);
        }

        try (DataInputStream input = new DataInputStream(new FileInputStream("temp.dat"))) {
            System.out.println(input.readUTF() + " " + input.readDouble());
            System.out.println(input.readUTF() + " " + input.readDouble());
            System.out.println(input.readUTF() + " " + input.readDouble());
        }
    }
}
