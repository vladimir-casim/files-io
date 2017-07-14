package liang.binaryio.ex_17_06;

import java.io.*;

/**
 * (Store Loan objects) The Loan class in Listing 10.2 does not implement
 * Serializable. Rewrite the Loan class to implement Serializable. Write
 * a program that creates five Loan objects and stores them in a file named
 * Exercise17_06.dat.
 *
 * Created by Vladimir
 */

public class Exercise_17_06 {

    public static final String PATH="src/main/resources/";

    public static void main(String[] args) {
        File file = new File(PATH + "Exercise17_06.dat");

        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(bos)
             ) {

            Loan[] loanList = {
                    new Loan(10, 2,7000),
                    new Loan(5, 1,4000),
                    new Loan(11, 3,21000),
                    new Loan(9, 5,5000),
                    new Loan(15, 4,8000)
            };

            for (Loan loan: loanList) {
                objectOutputStream.writeObject(loan);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
