package tcp.file_transfer;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {
    public static void main(String[] args) {
        int port = 3001;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                new Thread(new FileHandler(socket)).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static class FileHandler implements Runnable {
        private Socket socket;

        public FileHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            File directory = new File("files");
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Create a filename based on the current time
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            File outputFile = new File(directory, "received_file_" + timestamp);

            try (DataInputStream dis = new DataInputStream(socket.getInputStream());
                 FileOutputStream fos = new FileOutputStream(outputFile)) {

                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = dis.read(buffer, 0, buffer.length)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
                System.out.println("File received successfully: " + outputFile.getName());
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
