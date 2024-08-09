package day20assignments;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WordFrequencyCounter {

    public static void main(String[] args) {
        // File paths
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        // Map to store word frequencies
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Read the input file and count word frequencies
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+"); // Split by whitespace
                for (String word : words) {
                    word = word.toLowerCase(); // Convert to lowercase to avoid case sensitivity
                    wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        // Write the word frequencies to the output file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            Set<Map.Entry<String, Integer>> entrySet = wordCountMap.entrySet();
            for (Map.Entry<String, Integer> entry : entrySet) {
                writer.write(entry.getKey() + ": " + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }

        System.out.println("Word frequency count has been written to " + outputFile);
    }
}
