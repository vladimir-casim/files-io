package liang.binaryio.ex_17_01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

/**
 * (Create a text file) Write a program to create a file named Exercise17_01.txt if
 * it does not exist. Append new data to it if it already exists. Write 100 integers
 * created randomly into the file using text I/O. Integers are separated by a space.
 *
 * Created by Vladimir
 */

public class Exercise_17_01 {
    public static void main(String[] args) {
        File file = new File("new.txt");
        Random rand = new Random();

        try {
            PrintWriter output = new PrintWriter(file);
            for (int i = 0; i < 10; i++) {
                output.print(rand.nextInt(100) + " ");
            }
            output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Scanner input = new Scanner(file);
            while(input.hasNext()) {
                System.out.println(input.nextInt());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
