package tcp.drawing;

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;

public class TCPDrawingClient1 {
    private static PrintWriter out;
    private static JFrame frame = new JFrame("Collaborative Drawing Client");
    private static DrawPanel drawPanel = new DrawPanel();

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 6789);
            out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Thread to listen to incoming drawing commands from the server
            new Thread(() -> {
                try {
                    String fromServer;
                    while ((fromServer = in.readLine()) != null) {
                        String finalFromServer = fromServer;
                        SwingUtilities.invokeLater(() -> drawPanel.processCommand(finalFromServer));
                    }
                } catch (IOException e) {
                    if (!socket.isClosed()) {
                        e.printStackTrace();
                    }
                }
            }).start();

            setupGUI();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void setupGUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 350);
        frame.add(drawPanel);
        frame.setVisible(true);

        drawPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                out.println("DRAW_POINT " + x + " " + y);
                SwingUtilities.invokeLater(() -> drawPanel.drawPoint(x, y));
            }
        });
    }
}
