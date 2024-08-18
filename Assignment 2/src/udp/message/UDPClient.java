package udp.message;

import java.io.IOException;
import java.net.*;

public class UDPClient {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket()) {
            // Server address and port
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 5000;

            String message = "Hello from client";

            byte[] sendData = message.getBytes();

            // datagram packet to send to the server
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);

            socket.send(sendPacket);
            System.out.println("Sent to server: " + message);

            // Receive response from the server
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);


            socket.receive(receivePacket);
            String response = new String(receivePacket.getData()).trim();
            System.out.println("Server response: " + response);

        } catch (IOException e) {
            System.err.println("IOException caught: " + e.getMessage());
        }
    }
}
