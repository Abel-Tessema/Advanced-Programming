package udp.message;

import java.io.IOException;
import java.net.*;

public class UDPServer {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(5000)) {
            System.out.println("Server is running on port 5000...");

            while (true) {
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                socket.receive(receivePacket);
                System.out.println("Received from client: " + new String(receivePacket.getData()).trim());

                String responseMessage = "Server received: " + new String(receivePacket.getData()).trim();
                byte[] sendData = responseMessage.getBytes();

                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);

                socket.send(sendPacket);
            }
        } catch (IOException e) {
            System.err.println("IOException caught: " + e.getMessage());
        }

    }
}
