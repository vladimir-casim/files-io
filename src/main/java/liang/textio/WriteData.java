package liang.textio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by User on 18.04.2017.
 */
public class WriteData {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("scores.txt");

        if (file.exists()) {
            System.out.println("File already exists");
            System.exit(1);
        }

        try(
                PrintWriter output = new PrintWriter(file)
        ) {
            output.print("John T Smith ");
            output.println(90);
            output.print("Eric K Jones ");
            output.println(80);
        }
    }
}
