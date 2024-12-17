import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class Main extends JFrame {

    private JCheckBox sphereCheckBox;
    private JCheckBox coneCheckBox;
    private JCheckBox torusCheckBox;

    private JPanel drawingPanel;

    public Main() {
        setTitle("Geometric Shapes");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initUI();
    }

    private void initUI() {
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(3, 1));

        sphereCheckBox = new JCheckBox("Sphere");
        coneCheckBox = new JCheckBox("Cone");
        torusCheckBox = new JCheckBox("Torus");

        controlPanel.add(sphereCheckBox);
        controlPanel.add(coneCheckBox);
        controlPanel.add(torusCheckBox);

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
    }

    @Override
    public void start(Stage primaryStage) {
        // Создание сферы
        Sphere sphere = new Sphere(100);

        // Установка материала для сферы
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.BLUE); // Устанавливаем цвет сферы
        material.setSpecularColor(Color.WHITE); // Устанавливаем цвет подсветки
        sphere.setMaterial(material);

        // Определение позиции сферы
        sphere.setTranslateX(200); // Смещаем сферу по оси X
        sphere.setTranslateY(150); // Смещаем сферу по оси Y

        // Создание группы и добавление сферы в нее
        Group root = new Group();
        root.getChildren().add(sphere);

        // Создание сцены и добавление группы на нее
        Scene scene = new Scene(root, 400, 300, Color.WHITE);

        // Настройка отображения сцены
        primaryStage.setScene(scene);
        primaryStage.setTitle("Сфера в середине");
        primaryStage.show();
    }

    private void drawCone(Graphics2D g, int width, int height) {
        int[] xPoints = {width / 2, width / 2 - 50, width / 2 + 50};
        int[] yPoints = {height / 4, height / 4 + 100, height / 4 + 100};

        g.drawPolygon(xPoints, yPoints, 3);
    }

    private void drawTorus(Graphics2D g, int width, int height) {
        int centerX = width * 3 / 4;
        int centerY = height / 2;
        int outerRadius = Math.min(width, height) / 8;
        int innerRadius = outerRadius / 2;

        g.drawOval(centerX - outerRadius, centerY - innerRadius, 2 * outerRadius, 2 * innerRadius);
        g.drawOval(centerX - innerRadius, centerY - outerRadius, 2 * innerRadius, 2 * outerRadius);
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
