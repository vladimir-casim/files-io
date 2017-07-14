package liang.binaryio.ex_17_02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

/**
 * (Create a binary data file) Write a program to create a file named
 * Exercise17_02.dat if it does not exist. Append new data to it if it already exists.
 * Write 100 integers created randomly into the file using binary I/O.
 *
 * Created by Vladimir
 */

public class Exercise_17_02 {
    public static void main(String[] args) {
        try {
            FileOutputStream fileOutput = new FileOutputStream("src/main/resources/Exercise17_02.dat", true);
            Random rand = new Random();

            for (int i=0; i<10; i++) {
                fileOutput.write(rand.nextInt(100));
            }
            fileOutput.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/Exercise17_02.dat");
            int value;
            while ((value = fileInputStream.read()) != -1) {
                System.out.print(value + " ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
