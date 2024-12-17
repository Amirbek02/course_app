import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Создаем флажки для выбора фигур
        CheckBox sphereCheckBox = new CheckBox("Сфера");
        CheckBox coneCheckBox = new CheckBox("Конус");
        CheckBox torusCheckBox = new CheckBox("Тор");

        // Создаем область для рисования
        VBox root = new VBox();
        root.getChildren().addAll(sphereCheckBox, coneCheckBox, torusCheckBox);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Отображение геометрических фигур");
        primaryStage.show();

        // Обработка событий для отображения выбранных фигур
        sphereCheckBox.setOnAction(event -> {
            if (sphereCheckBox.isSelected()) {
                drawSphere(scene);
            }
        });

        coneCheckBox.setOnAction(event -> {
            if (coneCheckBox.isSelected()) {
                drawCone(scene);
            }
        });

        torusCheckBox.setOnAction(event -> {
            if (torusCheckBox.isSelected()) {
                drawTorus(scene);
            }
        });
    }

    // Метод для рисования сферы
    private void drawSphere(Scene scene) {
        Circle circle = new Circle(200, 200, 100);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.TRANSPARENT);
        ((Color) circle.getStroke()).getOpacity();
        ((Color) circle.getFill()).getOpacity();
        ((Color) circle.getStroke()).darker();
        ((Color) circle.getFill()).darker();
        ((Color) circle.getStroke()).saturate();
        ((Color) circle.getFill()).saturate();
        ((Color) circle.getStroke()).brighter();
        ((Color) circle.getFill()).brighter();
        ((Color) circle.getStroke()).grayscale();
        ((Color) circle.getFill()).grayscale();
        ((Color) circle.getStroke()).invert();
        ((Color) circle.getFill()).invert();
        ((Color) circle.getStroke()).saturate();
        ((Color) circle.getFill()).saturate();
        ((Color) circle.getStroke()).saturate();
        ((Color) circle.getFill()).saturate();
        ((Color) circle.getStroke()).saturate();
        ((Color) circle.getFill()).saturate();
        scene.getRoot().getChildrenUnmodifiable().add(circle);
    }

    // Метод для рисования конуса
    private void drawCone(Scene scene) {
        Cylinder cone = new Cylinder(50, 100);
        cone.setTranslateX(200);
        cone.setTranslateY(200);
        cone.setMaterial(new javafx.scene.paint.PhongMaterial(Color.BLUE));
        scene.getRoot().getChildrenUnmodifiable().add(cone);
    }

    // Метод для рисования тора
    private void drawTorus(Scene scene) {
        Torus torus = new Torus(100, 40);
        torus.setTranslateX(200);
        torus.setTranslateY(200);
        torus.setMaterial(new PhongMaterial(Color.GREEN));
        scene.getRoot().getChildrenUnmodifiable().add(torus);
    }
}
