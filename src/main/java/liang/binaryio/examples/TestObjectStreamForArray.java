package liang.binaryio.examples;


import java.io.*;

public class TestObjectStreamForArray {

    public static final String PATH = "src/main/resources";

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        int[] numbers = {1, 2, 3, 4, 5};
        String[] strings = {"John", "Susan", "Kim"};

        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(PATH + "array.dat"))) {
            output.writeObject(numbers);
            output.writeObject(strings);
        }

        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(PATH + "array.dat"))) {
            int[] newNumbers = (int[])(input.readObject());
            String[] newStrings = (String[])(input.readObject());

            for (int i = 0; i < newNumbers.length; i++) {
                System.out.print(newNumbers[i] + " ");
            }
            System.out.println();

            for (int i = 0; i < newStrings.length; i++) {
                System.out.print(newStrings[i] + " ");
            }
        }
    }
}
