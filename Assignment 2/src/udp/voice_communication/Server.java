package udp.voice_communication;

import java.net.*;
import javax.sound.sampled.*;

public class Server {
    private static final int PORT = 50005;
    private static final int BUFFER_SIZE = 4096;

    public static void main(String[] args) {
        DatagramSocket socket = null;
        SourceDataLine speakers = null;

        try {
            socket = new DatagramSocket(PORT);

            AudioFormat format = new AudioFormat(44100.0f, 16, 2, true, true);
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
            speakers = (SourceDataLine) AudioSystem.getLine(info);
            speakers.open(format);
            speakers.start();

            byte[] buffer = new byte[BUFFER_SIZE];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            System.out.println("Server is listening on port " + PORT);

            while (true) {
                socket.receive(packet);

                // Log the size of the received data and first few bytes
                System.out.print("Received " + packet.getLength() + " bytes: ");
                for (int i = 0; i < Math.min(10, packet.getLength()); i++) {
                    System.out.print(buffer[i] + " ");
                }
                System.out.println();

                speakers.write(packet.getData(), 0, packet.getLength());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (speakers != null) {
                speakers.drain();
                speakers.close();
            }
            if (socket != null) {
                socket.close();
            }
        }
    }
}
