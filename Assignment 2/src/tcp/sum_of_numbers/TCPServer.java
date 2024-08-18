package tcp.sum_of_numbers;

import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(6789)) {
            System.out.println("Server is listening on port 6789");

            while (true) {
                try (Socket socket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

                    System.out.println("New client connected");

                    // Read two numbers from the client
                    int number1 = Integer.parseInt(in.readLine());
                    int number2 = Integer.parseInt(in.readLine());

                    // Calculate their sum
                    int sum = number1 + number2;

                    // Send the sum back to the client
                    out.println(sum);
                } catch (IOException | NumberFormatException e) {
                    System.out.println("Error occurred: " + e.getMessage());
                }
            }
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
