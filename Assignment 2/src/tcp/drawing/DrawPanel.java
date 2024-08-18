package tcp.drawing;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawPanel extends JPanel {
    private final List<Point> points = new ArrayList<>();

    public synchronized void drawPoint(int x, int y) {
        points.add(new Point(x, y));
        repaint();
    }

    public synchronized void processCommand(String command) {
        if (command.startsWith("DRAW_POINT")) {
            String[] parts = command.split(" ");
            int x = Integer.parseInt(parts[1]);
            int y = Integer.parseInt(parts[2]);
            drawPoint(x, y);
        }
    }

    @Override
    protected synchronized void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Point point : points) {
            g.fillOval(point.x, point.y, 5, 5);
        }
    }
}
