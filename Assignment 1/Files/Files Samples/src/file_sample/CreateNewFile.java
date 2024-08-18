package file_sample;

import java.io.File;
import java.io.IOException;

public class CreateNewFile {
    public static void main(String[] args) {
        String filePath = "src/file_sample/files/createNewFile.txt";
        File file = new File(filePath);
        try {
            if (file.createNewFile()) {
                System.out.println("The file " + file.getName() + " has been created successfully.");
            } else {
                System.out.println("The file " + file.getName() + " already exists.");
            }
        } catch (IOException e) {
            System.err.println("An error occurred while creating the file.");
            System.err.println(e.getMessage());
        }
    }
}
