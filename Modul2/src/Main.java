import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Main extends JFrame {

    private JCheckBox sphereCheckBox;
    private JCheckBox coneCheckBox;
    private JCheckBox torusCheckBox;
    private JCheckBox icosahedronCheckBox;
    private JCheckBox tetrahedronCheckBox;
    private JCheckBox octahedronCheckBox;
    private JCheckBox hexahedronCheckBox;
    private JCheckBox dodecahedronCheckBox;

    private JPanel drawingPanel;

    public Main() {
        setTitle("Geometric Shapes");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initUI();
    }

    private void initUI() {
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(8, 1));

        sphereCheckBox = new JCheckBox("Sphere");
        coneCheckBox = new JCheckBox("Cone");
        torusCheckBox = new JCheckBox("Torus");
        icosahedronCheckBox = new JCheckBox("Icosahedron");
        tetrahedronCheckBox = new JCheckBox("Tetrahedron");
        octahedronCheckBox = new JCheckBox("Octahedron");
        hexahedronCheckBox = new JCheckBox("Hexahedron");
        dodecahedronCheckBox = new JCheckBox("Dodecahedron");

        controlPanel.add(sphereCheckBox);
        controlPanel.add(coneCheckBox);
        controlPanel.add(torusCheckBox);
        controlPanel.add(icosahedronCheckBox);
        controlPanel.add(tetrahedronCheckBox);
        controlPanel.add(octahedronCheckBox);
        controlPanel.add(hexahedronCheckBox);
        controlPanel.add(dodecahedronCheckBox);

        drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D g2d = (Graphics2D) g;
                int width = getWidth();
                int height = getHeight();

                g2d.setColor(Color.WHITE);
                g2d.fillRect(0, 0, width, height);

                g2d.setColor(Color.BLACK);

                if (sphereCheckBox.isSelected()) {
                    drawSphere(g2d, width, height);
                }
                if (coneCheckBox.isSelected()) {
                    drawCone(g2d, width, height);
                }
                if (torusCheckBox.isSelected()) {
                    drawTorus(g2d, width, height);
                }
                if (icosahedronCheckBox.isSelected()) {
                    drawIcosahedron(g2d, width, height);
                }
                if (tetrahedronCheckBox.isSelected()) {
                    drawTetrahedron(g2d, width, height);
                }
                if (octahedronCheckBox.isSelected()) {
                    drawOctahedron(g2d, width, height);
                }
                if (hexahedronCheckBox.isSelected()) {
                    drawHexahedron(g2d, width, height);
                }
                if (dodecahedronCheckBox.isSelected()) {
                    drawDodecahedron(g2d, width, height);
                }
            }
        };

        setLayout(new BorderLayout());
        add(controlPanel, BorderLayout.WEST);
        add(drawingPanel, BorderLayout.CENTER);

        ItemListener itemListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                drawingPanel.repaint();
            }
        };

        sphereCheckBox.addItemListener(itemListener);
        coneCheckBox.addItemListener(itemListener);
        torusCheckBox.addItemListener(itemListener);
        icosahedronCheckBox.addItemListener(itemListener);
        tetrahedronCheckBox.addItemListener(itemListener);
        octahedronCheckBox.addItemListener(itemListener);
        hexahedronCheckBox.addItemListener(itemListener);
        dodecahedronCheckBox.addItemListener(itemListener);
    }

    private void drawSphere(Graphics2D g, int width, int height) {
        int diameter = Math.min(width, height);
        int x = (width - diameter) / 2;
        int y = (height - diameter) / 2;
        g.setColor(Color.RED); // Пример цвета для сферы
        g.fillOval(x, y, diameter, diameter);
    }


    private void drawCone(Graphics2D g, int width, int height) {
        int diameter = Math.min(width, height);
        int x = (width - diameter) / 2;
        int y = (height - diameter) / 2;
        int[] xPoints = {x + diameter / 2, x, x + diameter, x + diameter / 2};
        int[] yPoints = {y, y + diameter, y + diameter, y};
        g.setColor(Color.GREEN); // Пример цвета для конуса
        g.fillPolygon(xPoints, yPoints, 4);
        g.drawOval(x, y + diameter / 2, diameter, diameter / 2);
    }


    private void drawTorus(Graphics2D g, int width, int height) {
        int diameter = Math.min(width, height);
        int x = (width - diameter) / 2;
        int y = (height - diameter) / 2;
        int innerRadius = diameter / 4;
        int outerRadius = diameter / 2;
        g.setColor(Color.BLUE); // Пример цвета для тора
        g.drawOval(x + outerRadius / 2, y + outerRadius / 2, outerRadius, outerRadius);
        g.drawOval(x + innerRadius / 2, y + innerRadius / 2, innerRadius, innerRadius);
    }


    private void drawIcosahedron(Graphics2D g, int width, int height) {
        // Реализация отображения икосаэдра
    }

    private void drawTetrahedron(Graphics2D g, int width, int height) {
        // Реализация отображения тетраэдра
    }

    private void drawOctahedron(Graphics2D g, int width, int height) {
        // Реализация отображения октаэдра
    }

    private void drawHexahedron(Graphics2D g, int width, int height) {
        // Реализация отображения гексаэдра
    }

    private void drawDodecahedron(Graphics2D g, int width, int height) {
        // Реализация отображения додекаэдра
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main app = new Main();
                app.setVisible(true);
            }
        });
    }
}
