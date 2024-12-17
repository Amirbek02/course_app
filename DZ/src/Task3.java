import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Map<String, String> products = new HashMap<>();
        products.put("Фрукты", "Яблоко, Груша, Банан, Банан");
        products.put("Овощи", "Помидор, Огурец, Морковь");
        products.put("Фрукты2", "Яблоко, Груша, Банан");
        products.put("Фрукты2", "Яблоко, Груша, Банан");

        Map<String, Integer> frequency = new HashMap<>();
        for (String value : products.values()) {
            frequency.put(value, frequency.getOrDefault(value, 0) + 1);
        }

        Scanner scanner = new Scanner(System.in);
        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() > 2) {
                System.out.println("Введите новое значение для '" + entry.getKey() + "': ");
                String newValue = scanner.nextLine();
                products.values().removeIf(value -> value.equals(entry.getKey()));
                products.put(entry.getKey(), newValue);
            }
        }

        System.out.println("Измененная коллекция: " + products);
    }
}
