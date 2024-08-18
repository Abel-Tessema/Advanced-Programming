package pipe_sample;

import java.io.*;

public class BufferedDataTransfer {
    public static void main(String[] args) throws IOException {
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);

        Runnable writerRunnable = () -> {
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(pipedOutputStream))) {
                String sentData = "Ha balu, tezkar belu.";
                writer.write(sentData);
//                writer.newLine();
                writer.flush();
                pipedOutputStream.close();
                System.out.println("Sent data (through buffer): \"" + sentData + "\"");
            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        Runnable readerRunnable = () -> {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(pipedInputStream))) {
                StringBuilder receivedData = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    receivedData.append(line);
//                    receivedData.append(System.lineSeparator());
                }
                pipedInputStream.close();
                System.out.println("Received data (through buffer): \"" + receivedData + "\"");
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