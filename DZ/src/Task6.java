import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Task6 {
    public static void main(String[] args) {
        Map<String, String> products = Map.of(
                "Фрукты", "Яблоко, Груша, Банан",
                "Овощи", "Помидор, Огурец, Морковь",
                "Молочные продукты", "Молоко, Сыр, Йогурт"
        );

        for (Map.Entry<String, String> entry : products.entrySet()) {
            try {
                FileWriter writer = new FileWriter(entry.getKey() + ".txt");
                writer.write(entry.getValue());
                writer.close();
                System.out.println("Категория '" + entry.getKey() + "' сохранена в файл '" + entry.getKey() + ".txt'");
            } catch (IOException e) {
                System.out.println("Ошибка при сохранении файла: " + e.getMessage());
            }
        }
    }
}
