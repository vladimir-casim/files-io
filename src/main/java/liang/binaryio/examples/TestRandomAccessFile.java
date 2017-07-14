package liang.binaryio.examples;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class TestRandomAccessFile {

    public static final String PATH="src/main/resources/";

    public static void main(String[] args) {
        try (RandomAccessFile inout = new RandomAccessFile(PATH + "inout.dat", "rw");) {

            inout.setLength(0);

            for (int i = 0; i < 200; i++) {
                inout.writeInt(i);
            }

            System.out.println("Current file length is " + inout.length());

            // Retrieve the first number
            inout.seek(0); // Move the file pointer to the beginning
            System.out.println("The first number is: " + inout.readInt());

            // Retrieve the second number
            inout.seek(1 * 4); // Move the file pointer to second position
            System.out.println("The second number is " + inout.readInt());

            inout.seek(9 * 4);
            System.out.println("The tenth number is " + inout.readInt());

            // Modify the eleventh number
            inout.writeInt(555);

            // Append a new number
            inout.seek(inout.length()); // Move the file pointer to the end
            inout.writeInt(999);

            // Display the new length
            System.out.println("The new length is " + inout.length());

            // Retrieve the new eleventh number
            inout.seek(10 * 4); // Move the file pointer to the eleventh number
            System.out.println("The eleventh number is " + inout.readInt());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
