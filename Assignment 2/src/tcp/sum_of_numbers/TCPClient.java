package tcp.sum_of_numbers;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 6789);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            // Get two numbers from the user
            System.out.print("Enter the first number: ");
            int number1 = scanner.nextInt();
            System.out.print("Enter the second number: ");
            int number2 = scanner.nextInt();

            // Send the numbers to the server
            out.println(number1);
            out.println(number2);

            // Read the sum from the server
            String response = in.readLine();
            System.out.println("The sum is: " + response);
        } catch (IOException ex) {
            System.out.println("Client exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
