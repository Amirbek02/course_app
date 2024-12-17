import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // Шаг 1: Создание директории
        String dirName = "my_directory";
        File dir = new File(dirName);
        if (!dir.exists()) {
            if (dir.mkdirs()) {
                System.out.println("Директория '" + dirName + "' создана.");
            } else {
                System.out.println("Не удалось создать директорию '" + dirName + "'.");
            }
        } else {
            System.out.println("Директория '" + dirName + "' уже существует.");
        }

        // Шаг 2: Ввод текста и разбиение на предложения
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст: ");
        String text = scanner.nextLine();
        String[] sentences = text.split("(?<=[.!?])\\s+");

        for (int i = 0; i < sentences.length; i++) {
            String fileName = dirName + "/sentence_" + (i + 1) + ".txt";
            try (FileWriter writer = new FileWriter(fileName)) {
                writer.write(sentences[i]);
                System.out.println("Создан файл: " + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Шаг 3: Вывод содержимого каталога
        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    long fileSize = file.length();
                    String absolutePath = file.getAbsolutePath();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String lastModified = sdf.format(file.lastModified());
                    System.out.println("Название файла: " + file.getName() +
                            ", Абсолютный путь: " + absolutePath +
                            ", Размер: " + fileSize + " байт" +
                            ", Дата модификации: " + lastModified);
                }
            }
        } else {
            System.out.println("Директория '" + dirName + "' не существует.");
        }

        // Шаг 4: Проверка наличия файла и создание/удаление
        System.out.println("Введите название файла для проверки: ");
        String fileName = scanner.nextLine();
        String filePath = dirName + "/" + fileName;
        File file = new File(filePath);

        if (file.exists()) {
            if (file.delete()) {
                System.out.println("Файл '" + fileName + "' удален.");
                FileWriter writer = new FileWriter(filePath);
                    String parentDir = file.getParent();
                    writer.write("Родительский каталог: " + parentDir + "\nПуть к файлу: " + filePath);
                    System.out.println("Файл '" + fileName + "' создан и заполнен информацией.");
                           } else {
                System.out.println("Не удалось удалить файл '" + fileName + "'.");
            }
        } else {
            try (FileWriter writer = new FileWriter(filePath)) {
                String parentDir = file.getParent();
                writer.write("Родительский каталог: " + parentDir + "\nПуть к файлу: " + filePath);
                System.out.println("Файл '" + fileName + "' создан и заполнен информацией.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Шаг 5: Копирование файла на рабочий стол
        String userHome = System.getProperty("user.home");
        String desktopPath = userHome + "/Desktop/";
        File sourceFile = new File(filePath);
        File destFile = new File(desktopPath + sourceFile.getName());

        try {
            Files.copy(sourceFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Файл '" + sourceFile.getName() + "' скопирован на рабочий стол.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
