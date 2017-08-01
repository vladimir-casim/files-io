package liang.binaryio;

import java.io.*;
import java.util.Random;

/**
 * (Sum all the integers in a binary data file) Suppose a binary data file named
 * Exercise17_03.dat has been created and its data are created using
 * writeInt(int) in DataOutputStream. The file contains an unspecified
 * number of integers. Write a program to find the sum of the integers.
 *
 * Created by Vladimir
 */

public class Exercise_17_03 {

    public static final String PATH="src/main/resources/";

    public static void main(String[] args) {
        Random rand = new Random();
        int sum = 0;

        try {
            DataOutputStream outputStream = new DataOutputStream(
                    new FileOutputStream(PATH + "Exercise17_03.dat"));

            int minNumOfIntegers = 5;
            int maxNumOfIntegers = 12;
            int numOfIntegers = minNumOfIntegers + rand.nextInt((maxNumOfIntegers - minNumOfIntegers) + 1);
            for (int i = 0; i < numOfIntegers; i++) {
                outputStream.write(rand.nextInt(100));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            DataInputStream inputStream = new DataInputStream(
                    new FileInputStream(PATH + "Exercise17_03.dat"));

            int value;
            while((value = inputStream.readInt()) != -1) {
                sum = sum + value;
            }

        } catch (EOFException e) {
            System.out.println("\nAll data were read");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Sum " + sum);
    }
}
