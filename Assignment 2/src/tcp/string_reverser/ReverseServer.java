package tcp.string_reverser;

import java.io.*;
import java.net.*;

public class ReverseServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12349);
        System.out.println("Reverse Server is listening on port 12349");

        while (true) {
            Socket socket = serverSocket.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            String message = reader.readLine();
            writer.println(new StringBuilder(message).reverse()); // Reverse the string
            socket.close();
        }
    }
}
