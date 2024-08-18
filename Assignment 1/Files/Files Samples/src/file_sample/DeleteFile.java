package file_sample;

import java.io.File;

public class DeleteFile {
    public static void main(String[] args) {
        String filePath = "src/file_sample/files/deleteFile.txt";
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("The file " + file.getName() + " has been deleted successfully.");
            } else {
                System.err.println("An error occurred while attempting to delete the file " + file.getName() + ".");
            }
        } else {
            System.err.println("The file " + file.getName() + " does not exist.");
        }
    }
}
