package udp.network_discovery;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DiscoveryServer {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(9876);
            byte[] receiveData = new byte[1024];

            System.out.println("Server is running and waiting for discovery requests...");

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                String requestData = new String(receivePacket.getData(), 0, receivePacket.getLength());
                if (requestData.trim().equals("DISCOVER_REQUEST")) {
                    // Respond with information about available services
                    String responseData = "DISCOVER_RESPONSE: Service A, Service B, Service C";
                    byte[] sendData = responseData.getBytes();
                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
                            receivePacket.getAddress(), receivePacket.getPort());
                    socket.send(sendPacket);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}
