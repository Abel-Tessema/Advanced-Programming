package udp.weather;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.HashMap;
import java.util.Map;

public class WeatherServer {
    private static final int PORT = 9876;

    // Mock weather data
    static final Map<String, String> weatherData = new HashMap<>();
    static {
        weatherData.put("New York", "Sunny, 25°C");
        weatherData.put("Los Angeles", "Cloudy, 18°C");
        weatherData.put("Chicago", "Rainy, 15°C");
        weatherData.put("Houston", "Thunderstorms, 22°C");
        weatherData.put("Phoenix", "Hot, 40°C");
    }

    public static void main(String[] args) {
        try (DatagramSocket serverSocket = new DatagramSocket(PORT)) {
            byte[] receiveBuffer = new byte[1024];

            System.out.println("Weather Server is running and waiting for requests...");

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                serverSocket.receive(receivePacket);

                // Spawn a new thread to handle the client request
                new Thread(new WeatherRequestHandler(serverSocket, receivePacket)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
