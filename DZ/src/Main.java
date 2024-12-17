import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Map<String,String> products = new HashMap<>();
        products.put("Груша", "Фрукты");
        products.put("Банан", "Фрукты");
        products.put("Яблоко", "Фрукты");

        products.put("Помидор", "Овощи");
        products.put("Огурец", "Овощи");
        products.put("Морковь", "Овощи");
        products.put("Помидор", "Овощи");

        products.put("Молоко", "Молочные продукты");
        products.put("Сыр", "Молочные продукты");
        products.put("Йогурт", "Молочные продукты");

// FIRST and SECOND
//      for (Map.Entry<String,String> entry : products.entrySet()) {
//          String category = entry.getValue();
//          String items = entry.getKey();
//          String fileName = category + ".txt";
//          FileWriter writer = new FileWriter(fileName);
//          writer.write(category + ": " + items + "\n");
//          writer.close();
//      }
//      File file = new File("products.txt");
//      FileReader fr = new FileReader(file);
//      BufferedReader br = new BufferedReader(fr);
//        String line;
//        while ((line = br.readLine()) != null) {
//            System.out.println(line);
//        }
//
//        br.close();
//        fr.close();


        Map<String, String> uniqueItems = new HashMap<>();
        for (Map.Entry<String, String> entry : products.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            if (uniqueItems.containsKey(key)) {
                System.out.println("Дубликат элемента '" + key + "' в категории '" + value + "'");
                System.out.println("Введите новое значение для этого элемента: ");
                String newValue = scanner.nextLine();
                uniqueItems.put(key, newValue);
            } else {
                uniqueItems.put(key, value);
            }
        }

//        Scanner scanner = new Scanner(System.in);
//
        Set<String> uniqueKeys = new HashSet<>();
        for (String key : products.keySet()) {
            if (!uniqueKeys.add(key)) {
                System.out.println("Дубликат элемента '" + key + "' в категории '" + products.get(key) + "'");
                System.out.println("Введите новое значение для этого элемента: ");
                String newValue = scanner.nextLine();
                products.put(key, newValue);
            }
        }



//        for (Map.Entry<String, String> entry : products.entrySet()) {
//            String category = entry.getKey();
//            String items = entry.getValue();
//            System.out.println(category + ": " + items);
//        }
//
//
//        Map<String, String> tropicalFruits = new HashMap<>();
//        tropicalFruits.put("Ананас", "Тропические фрукты");
//        tropicalFruits.put("Манго", "Тропические фрукты");
//        tropicalFruits.put("Папайя", "Тропические фрукты");
//
//        System.out.println("Коллекция тропических фруктов: " + tropicalFruits);
//
//        for(Map.Entry<String, String> tropicalFruit : tropicalFruits.entrySet()) {
//            boolean found = false;
//            for (String productList : products.values()) {
//                if (productList.contains((CharSequence) tropicalFruit)) {
//                    found = true;
//                    break;
//                }
//            }
//
//            if (found) {
//                System.out.println("Тропический фрукт '" + tropicalFruit + "' найден в основной коллекции продуктов.");
//            } else {
//                System.out.println("Тропический фрукт '" + tropicalFruit + "' не найден в основной коллекции продуктов.");
//            }
//        }
        //        FileWriter fileProduct = new FileWriter("products.txt");
//        for (Map.Entry<String,String> entry : products.entrySet()) {
//            String category = entry.getValue();
//            String items = entry.getKey();
//            fileProduct.write(category + ": " + items+ "\n");
//
//        }
//        fileProduct.close();


    }
}
