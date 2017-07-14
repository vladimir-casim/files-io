package liang.binaryio.ex_17_04;

import java.io.*;
import java.util.Scanner;

/**
 * (Convert a text file into UTF) Write a program that reads lines of characters from
 * a text file and writes each line as a UTF-8 string into a binary file. Display the
 * sizes of the text file and the binary file.
 *
 * Created by Vladimir
 */

public class Exercise_17_04 {

    public static final String PATH="src/main/resources/ex_17_04/";

    public static void main(String[] args) {
        File textFile = new File(PATH + "Exercise_17_04.txt");

        try(PrintWriter output = new PrintWriter(textFile)) {
            output.println("first line");
            output.println("second line");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        File binaryUtfFile = new File(PATH + "Exercise_17_04.utf");
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(binaryUtfFile))){
            Scanner input = new Scanner(textFile);
            String line;
            while (input.hasNext()) {
                line = input.nextLine();
                dataOutputStream.writeUTF(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
