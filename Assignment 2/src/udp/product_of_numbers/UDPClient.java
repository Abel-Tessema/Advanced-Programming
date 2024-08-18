package udp.product_of_numbers;

import java.net.*;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket();
             Scanner scanner = new Scanner(System.in)) {

            InetAddress serverAddress = InetAddress.getByName("localhost");
            byte[] sendBuffer;
            byte[] receiveBuffer = new byte[1024];

            // Get two numbers from the user
            System.out.print("Enter the first number: ");
            int number1 = scanner.nextInt();
            System.out.print("Enter the second number: ");
            int number2 = scanner.nextInt();

            // Send the numbers to the server
            String dataToSend = number1 + " " + number2;
            sendBuffer = dataToSend.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, 9876);
            socket.send(sendPacket);

            // Receive the product from the server
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            socket.receive(receivePacket);
            String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("The product is: " + response);
        } catch (Exception ex) {
            System.out.println("Client exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
