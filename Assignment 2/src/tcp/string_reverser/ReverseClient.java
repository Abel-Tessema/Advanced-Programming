package tcp.string_reverser;

import java.io.*;
import java.net.*;

public class ReverseClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12349);
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer.println("hello, server!");
        System.out.println("Received from server: " + reader.readLine());
        socket.close();
    }
}
