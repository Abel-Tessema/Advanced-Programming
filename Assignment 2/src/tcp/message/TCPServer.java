package tcp.message;

import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server is listening on port 5000...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket);

                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                // Read input from the client and echo it back
                String inputLine = in.readUTF();
                System.out.println("Received from client: " + inputLine);
                out.writeUTF("Server received: " + inputLine); // Echo back to client

                // Close the connection
                clientSocket.close();
            }
        } catch (IOException e) {
            System.err.println("Exception caught when trying to listen on port 5000 or listening for a connection");
            System.err.println(e.getMessage());
        }

    }
}
