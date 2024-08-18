package udp.sensor_data_collection;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class SensorDataServer {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(9876);
            byte[] receiveData = new byte[1024];

            System.out.println("Server is running and waiting for sensor data...");

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                String sensorData = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received sensor data: " + sensorData);
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
