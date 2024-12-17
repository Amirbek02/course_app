import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Task5 {
    public static void main(String[] args) {
        Map<String, String> products = Map.of(
                "Фрукты", "Яблоко, Груша, Банан",
                "Овощи", "Помидор, Огурец, Морковь",
                "Тропические фрукты", "Ананас, Манго, Папайя"
        );

        Set<String> tropicalFruits = new HashSet<>();
        tropicalFruits.add("Ананас");
        tropicalFruits.add("Манго");

        Set<String> matchingProducts = new HashSet<>();
        for (String value : products.values()) {
            String[] items = value.split(", ");
            for (String item : items) {
                if (tropicalFruits.contains(item)) {
                    matchingProducts.add(item);
                }
            }
        }

        System.out.println("Продукты, совпадающие с тропическими фруктами: " + matchingProducts);
    }
}
