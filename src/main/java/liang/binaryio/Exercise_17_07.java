package liang.binaryio;

import liang.binaryio.ex_17_06.Loan;

import java.io.*;
import java.util.ArrayList;

/**
 * (Restore objects from a file) Suppose a file named Exercise17_07.dat has been
 * created using the ObjectOutputStream. The file contains Loan objects. The
 * Loan class in Listing 10.2 does not implement Serializable. Rewrite the
 * Loan class to implement Serializable. Write a program that reads the Loan
 * objects from the file and displays the total loan amount. Suppose you don’t
 * know how many Loan objects are there in the file, use EOFException to end
 * the loop.
 *
 * Created by Vladimir
 */

public class Exercise_17_07 {

    public static final String PATH = "src/main/resources/";

    public static void main(String[] args)  {
        File file = new File(PATH + "Exercise17_06.dat");
        ArrayList<Loan> loanList = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(file);
             BufferedInputStream bis = new BufferedInputStream(fis);
             ObjectInputStream ois = new ObjectInputStream(bis)) {

            while (true) {
                loanList.add((Loan) ois.readObject());
            }
        } catch (EOFException ex) {
            System.out.println("All data were read");
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        for (Loan loan : loanList) {
            System.out.println(loan);
        }
    }

}
