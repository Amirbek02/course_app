import javax.swing.*;
import java.awt.*;

public class tzd {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Создание нового окна
            JFrame frame = new JFrame("Мост");

            // Установка операции закрытия окна
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Создание новой панели для отрисовки моста
            JPanel panel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    drawBridge(g);
                }
            };

            // Установка размеров панели
            panel.setPreferredSize(new Dimension(800, 400));

            // Добавление панели на окно
            frame.getContentPane().add(panel);

            // Установка размеров окна
            frame.pack();

            // Отображение окна
            frame.setVisible(true);
        });
    }

    // Метод для рисования моста
    private static void drawBridge(Graphics g) {
        // Рисование реки под мостом (голубая заливка)
        g.setColor(new Color(0, 102, 204));
        g.fillRect(0, 200, 800, 200);

        // Рисование башен моста (серые прямоугольники)
        g.setColor(Color.GRAY);
        g.fillRect(100, 100, 100, 200);
        g.fillRect(600, 100, 100, 200);

        // Рисование дорожной поверхности моста (коричневая заливка)
        g.setColor(new Color(139, 69, 19));
        g.fillRect(0, 150, 800, 100);

        // Рисование ограждений моста (красные линии)
        g.setColor(Color.RED);
        g.drawLine(100, 150, 200, 150);
        g.drawLine(600, 150, 700, 150);

        // Рисование подпорных структур моста (коричневые прямоугольники)
        g.setColor(new Color(139, 69, 19));
        g.fillRect(125, 100, 50, 150);
        g.fillRect(625, 100, 50, 150);
    }
}