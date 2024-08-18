package pipe_sample;

import java.io.*;

public class DataTransfer {
    public static void main(String[] args) throws IOException {
        PipedOutputStream outputStream = new PipedOutputStream();
        PipedInputStream inputStream = new PipedInputStream(outputStream);

        Runnable writerRunnable = () -> {
            try {
                String sentData = "Yene tolo tolo bet, gidgidaw senbelett.";
                outputStream.write(sentData.getBytes());
                outputStream.close();
                System.out.println("Sent data: \"" + sentData + "\"");
            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        Runnable readerRunnable = () -> {
            try {
                int character;
                StringBuilder builder = new StringBuilder();
                while ((character = inputStream.read()) != -1) {
                    builder.append((char) character);
                }
                inputStream.close();
                System.out.println("Received data: \"" + builder + "\"");
            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        Thread writerThread = new Thread(writerRunnable);
        Thread readerThread = new Thread(readerRunnable);

        writerThread.start();
        readerThread.start();
    }
}