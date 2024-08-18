package file_sample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class LockFileForWriting {
    public static void main(String[] args) {
        String filePath = "src/file_sample/files/lockFileForWriting.txt";
        Path path = Path.of(filePath);
        try (
                FileChannel channel = FileChannel.open(path, StandardOpenOption.WRITE, StandardOpenOption.CREATE);
                FileWriter fileWriter = new FileWriter(filePath);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        ) {
            FileLock lock = channel.lock();
            System.out.println("File lock acquired.");

            bufferedWriter.write("Chebude Dande segno tewelede.");
            bufferedWriter.newLine();

            lock.release();
            System.out.println("File lock released.");
        } catch (IOException e) {
            System.err.println("An error occurred while trying to lock the file.");
        }
    }
}
