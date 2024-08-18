package file_sample;

import java.io.File;
import java.io.IOException;

public class GetFileInfo {
    public static void main(String[] args) throws IOException {
        String filePath = "src/file_sample/files/getFileInfo.csv";
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println("File name: " + file.getName());
            System.out.println("Can read: " + file.canRead());
            System.out.println("Can write: " + file.canWrite());
            System.out.println("Is file: " + file.isFile());
            System.out.println("Is directory: " + file.isDirectory());
            System.out.println("Is absolute: " + file.isAbsolute());
            System.out.println("Is hidden: " + file.isHidden());
            System.out.println("Exists: " + file.exists());
            System.out.println("Last modified: " + file.lastModified());
            System.out.println("Length: " + file.length() + " bytes");
            System.out.println("Get absolute path: " + file.getAbsolutePath());
            System.out.println("Get canonical path: " + file.getCanonicalPath());
            System.out.println("Get parent: " + file.getParent());
            System.out.println("Get free space: " + file.getFreeSpace());
            System.out.println("Get usable space: " + file.getUsableSpace());
            System.out.println("Get total space: " + file.getTotalSpace());

        } else {
            System.err.println("The file " + file.getName() + " does not exist.");
        }
    }
}
