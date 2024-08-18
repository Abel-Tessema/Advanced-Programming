package file_sample;

import java.io.File;

public class ListFilesInDirectory {
    public static void main(String[] args) {
        String directoryPath = "src/file_sample/files/";
        File directory = new File(directoryPath);
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null && files.length > 0) {
                System.out.println("Files in the directory: " + directoryPath + " are:");
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println(file.getName());
                    }
                }
            } else {
                System.out.println("The directory " + directory.getName() + " is empty.");
            }
        } else {
            System.err.println("The path provided is not a directory.");
        }
    }
}
