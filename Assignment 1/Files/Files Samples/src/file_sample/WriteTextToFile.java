package file_sample;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteTextToFile {
    public static void main(String[] args) {
        String filePath = "src/file_sample/files/writeTextToFile.txt";
        File file = new File(filePath);
        String textToWrite = "Abebe besso bela.";
        try (
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        ) {
            bufferedWriter.write(textToWrite);
            bufferedWriter.newLine();

            System.out.println("Text has been written to " + file.getName() + " successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file.");
//            System.err.println(e.getMessage());
        }
    }
}
