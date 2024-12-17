import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Dynamic Image");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DynamicPanel dynamicPanel = new DynamicPanel();
        frame.add(dynamicPanel);

        frame.setVisible(true);

        Timer timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dynamicPanel.movePoints();
            }
        });
        timer.start();
    }
}

class DynamicPanel extends JPanel {
    private List<List<Point>> lines;

    public DynamicPanel() {
        lines = new ArrayList<>();
        List<Point> line = new ArrayList<>();
        line.add(new Point(50, 50)); // starting point 1
        line.add(new Point(250, 250)); // starting point 2
        lines.add(line);
    }

    public void movePoints() {
        for (List<Point> line : lines) {
            Point point1 = line.get(0);
            Point point2 = line.get(1);
            point1.y -= 2; // move point 1 up
            point2.y += 2; // move point 2 down
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawLines(g);
    }

    private void drawLines(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        for (List<Point> line : lines) {
            Point point1 = line.get(0);
            Point point2 = line.get(1);
            g2d.drawLine(point1.x, point1.y, point2.x, point2.y);
        }
    }
}
