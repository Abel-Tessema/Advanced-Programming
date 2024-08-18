package udp.weather;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

class WeatherRequestHandler implements Runnable {
    private DatagramSocket serverSocket;
    private DatagramPacket receivePacket;

    public WeatherRequestHandler(DatagramSocket serverSocket, DatagramPacket receivePacket) {
        this.serverSocket = serverSocket;
        this.receivePacket = receivePacket;
    }

    @Override
    public void run() {
        try {
            String cityName = new String(receivePacket.getData(), 0, receivePacket.getLength()).trim();
            System.out.println("Received request for weather report of: " + cityName);

            // Get the weather report for the city
            String weatherReport = WeatherServer.weatherData.getOrDefault(cityName, "Weather data not available");

            // Send the weather report back to the client
            byte[] sendBuffer = weatherReport.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(
                    sendBuffer,
                    sendBuffer.length,
                    receivePacket.getAddress(),
                    receivePacket.getPort()
            );
            serverSocket.send(sendPacket);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
