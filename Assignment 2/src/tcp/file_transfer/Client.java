package tcp.file_transfer;

import java.io.*;
import java.net.*;

public class Client {
    private String hostname;
    private int port;
    private String filePath;

    public Client(String hostname, int port, String filePath) {
        this.hostname = hostname;
        this.port = port;
        this.filePath = filePath;
    }

    public void sendFile() {
        try (Socket socket = new Socket(hostname, port);
             FileInputStream fis = new FileInputStream(filePath);
             DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer, 0, buffer.length)) != -1) {
                dos.write(buffer, 0, bytesRead);
            }
            System.out.println("File sent successfully.");
        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java FileTransferClient <hostname> <port> <file-path>");
            System.exit(1);
        }

        String hostname = args[0];
        int port = Integer.parseInt(args[1]);
        String filePath = args[2];

        Client client = new Client(hostname, port, filePath);
        client.sendFile();
    }
}
