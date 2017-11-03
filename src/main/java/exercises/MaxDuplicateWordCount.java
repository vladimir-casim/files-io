package exercises;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Created by Vladimir on 03.11.2017.
 */
public class MaxDuplicateWordCount {

    public static final String PATH="src/main/resources/";

    public static void main(String[] args) {
        Path filePath = Paths.get(PATH + "ex_17_04/Exercise_17_04.txt");
        try (Stream<String> lines = Files.lines(filePath);) {

            Stream<String> wordsStream = lines.flatMap(line -> Stream.of(line.split(" "))).distinct().sorted();
            wordsStream.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

        oldWayMethod();
    }

    public static void oldWayMethod() {
        File file = new File(PATH + "ex_17_04/Exercise_17_04.txt");
        Map<String, Integer> wordMap = new HashMap<>();
        try (FileInputStream fileInputStream = new FileInputStream(file);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    if (wordMap.containsKey(word))
                        wordMap.put(word, wordMap.get(word) + 1);
                    else
                        wordMap.put(word, 1);
                }
                line = bufferedReader.readLine();
            }
            System.out.println(wordMap.keySet());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
