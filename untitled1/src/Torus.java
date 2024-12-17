import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

public class Torus extends Application {

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

    public static void main(String[] args) {
        launch(args);
    }
}
