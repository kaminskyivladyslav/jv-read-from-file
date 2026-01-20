package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int value = reader.read();
            while (value != -1) {
                builder.append((char) value);
                value = reader.read();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read a file", e);
        }
        String[] text = builder.toString().toLowerCase().split("\\W+");
        StringBuilder finish = new StringBuilder();
        for (String word : text) {
            if (word.startsWith("w")) {
                finish.append(word)
                        .append(System.lineSeparator());
            }
        }
        String[] sort = finish.toString().split(System.lineSeparator());
        Arrays.sort(sort);
        if (finish.length() <= 0) {
            return new String[0];
        } else {
            return sort;
        }
    }
}
