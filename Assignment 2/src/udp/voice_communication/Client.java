package udp.voice_communication;

import java.net.*;
import javax.sound.sampled.*;

public class Client {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 50005;
    private static final int BUFFER_SIZE = 4096;

    public static void main(String[] args) {
        DatagramSocket socket = null;
        TargetDataLine microphone = null;

        try {
            socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName(SERVER_ADDRESS);

            AudioFormat format = new AudioFormat(44100.0f, 16, 2, true, true);
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
            microphone = (TargetDataLine) AudioSystem.getLine(info);
            microphone.open(format);
            microphone.start();

            byte[] buffer = new byte[BUFFER_SIZE];

            System.out.println("Client is sending audio to server...");

            while (true) {
                int bytesRead = microphone.read(buffer, 0, buffer.length);

                // Log the size of the captured data and first few bytes
                System.out.print("Captured " + bytesRead + " bytes: ");
                for (int i = 0; i < Math.min(10, bytesRead); i++) {
                    System.out.print(buffer[i] + " ");
                }
                System.out.println();

                DatagramPacket packet = new DatagramPacket(buffer, bytesRead, serverAddress, SERVER_PORT);
                socket.send(packet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (microphone != null) {
                microphone.close();
            }
            if (socket != null) {
                socket.close();
            }
        }
    }
}
