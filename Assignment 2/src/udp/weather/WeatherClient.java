package udp.weather;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class WeatherClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 9876;

    public static void main(String[] args) {
        try (DatagramSocket clientSocket = new DatagramSocket()) {
            InetAddress serverAddress = InetAddress.getByName(SERVER_ADDRESS);
            byte[] sendBuffer;
            byte[] receiveBuffer = new byte[1024];

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("Enter city name for weather report (or type 'exit' to quit): ");
                String cityName = scanner.nextLine();

                if ("exit".equalsIgnoreCase(cityName)) {
                    break;
                }

                // Send the city name to the server
                sendBuffer = cityName.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, SERVER_PORT);
                clientSocket.send(sendPacket);

                // Receive the weather report from the server
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                clientSocket.receive(receivePacket);

                String weatherReport = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Weather report for " + cityName + ": " + weatherReport);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
