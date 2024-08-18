package file_sample;

import java.io.File;

public class CheckFileExistence {
    public static void main(String[] args) {
        String filePath = "src/file_sample/files/checkFileExistence.txt";
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println("The file " + file.getName() + " exists.");
        } else {
            System.err.println("The file " + file.getName() + " does not exist.");
        }
    }
}