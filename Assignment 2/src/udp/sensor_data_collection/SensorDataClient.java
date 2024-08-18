package udp.sensor_data_collection;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

public class SensorDataClient {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        Random random = new Random();
        try {
            socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");

            while (true) {
                // Generate random sensor data
                int sensorValue = random.nextInt(100);
                String data = "Sensor value: " + sensorValue;

                // Send data to server
                byte[] sendData = data.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 9876);
                socket.send(sendPacket);

                Thread.sleep(1000); // Wait for 1 second before sending next data
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
