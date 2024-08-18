package tcp.message;

import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {

        try (Socket socket = new Socket("localhost", 5000)) {
            System.out.println("Connected to server on port 5000");

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            // Send a message to the server
            String message = "Hello from client";
            out.writeUTF(message);
            System.out.println("Sent to server: " + message);

            // Receive a response from the server
            String response = in.readUTF();
            System.out.println("Server response: " + response);

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: localhost");
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: localhost");
            System.err.println(e.getMessage());
        }

    }
}
