package file_sample;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadTextFileWithoutBuffer {
    public static void main(String[] args) {
        String filePath = "src/file_sample/files/readTextFileWithoutBuffer.txt";
        File file = new File(filePath);
        try (FileReader reader = new FileReader(file)) {
            int character;
            StringBuilder content = new StringBuilder();
            while ((character = reader.read()) != -1) {
                content.append((char) character);
            }

            System.out.println(content);
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file.");
            System.err.println(e.getMessage());
        }
    }
}
