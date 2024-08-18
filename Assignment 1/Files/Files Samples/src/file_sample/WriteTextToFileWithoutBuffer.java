package file_sample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteTextToFileWithoutBuffer {
    public static void main(String[] args) {
        String filePath = "src/file_sample/files/writeTextToFileWithoutBuffer.txt";
        File file = new File(filePath);
        String textToWrite = "Challa chube chebette.";
        try (FileWriter writer = new FileWriter(file)) {
            for (char character : textToWrite.toCharArray()) {
                writer.write(character);
            }

            System.out.println("Text has been written to " + file.getName() + " successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred while trying to write to " + file.getName() + ".");
//            System.err.println(e.getMessage());
        }
    }
}
