import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        PipedInputStream inputStream = new PipedInputStream();
        PipedOutputStream outputStream = new PipedOutputStream(inputStream);

        outputStream.write("Welcome to the pipe example.".getBytes());

        byte[] buffer = new byte[1024];
        int bytesRead = inputStream.read(buffer);

        String message = new String(buffer, 0, bytesRead);

        System.out.println(message);

        inputStream.close();
        outputStream.close();
    }
}
