import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Main {
    public static void createFileWithFileList(String directory, String filePath) {
        try (PrintWriter writer = new PrintWriter(filePath)) {
            writer.println("Список файлов:");
            Files.list(Paths.get(directory))
                    .forEach(path -> {
                        File file = path.toFile();
                        long creationTime = file.lastModified();
                        writer.println(path + ", " + file.getName() + ", " + creationTime);
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String folderPath = "C:\\Users\\Legion\\Desktop\\Univer\\2-courseInPolitekh\\java\\lb3\\src\\source\\ListFile";

        File folder = new File(folderPath);

        if (folder.exists()) {
            System.out.println("Папка существует.");

        } else {
            System.out.println("Папка не существует.");
        }
        // Задаем пути для файлов и каталогов
        String sourceDirectory = "C:\\Users\\Legion\\Desktop\\Univer\\2-courseInPolitekh\\java\\lb3\\src\\source";
        String destinationDirectory = "C:\\Users\\Legion\\Desktop\\Univer\\2-courseInPolitekh\\java\\lb3\\src\\destination";
        String fileListPath = "ListFile";
        String numbersFilePath = "Number";
        String palindromesFilePath = "Palindrome";
        String otherNumbersFilePath = "OtherNumber";

        createFileWithFileList(sourceDirectory, fileListPath);

        try {
            Files.copy(Paths.get(sourceDirectory, fileListPath), Paths.get(destinationDirectory, fileListPath), StandardCopyOption.REPLACE_EXISTING);
            Files.deleteIfExists(Paths.get(sourceDirectory, fileListPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        try (PrintWriter writer = new PrintWriter(new FileWriter(numbersFilePath, true))) {
            while (true) {
                System.out.print("Введите целое число (или 'стоп' для завершения): ");
                String input = scanner.nextLine().trim();
                if (input.equalsIgnoreCase("стоп")) {
                    break;
                }
                try {
                    int num = Integer.parseInt(input);
                    if (num >= 100 && num <= 999) {
                        writer.println(num);
                    } else {
                        num += 100;
                        writer.println(num);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: Введите целое число.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Scanner fileScanner = new Scanner(new File(numbersFilePath));
             PrintWriter palindromesWriter = new PrintWriter(palindromesFilePath);
             PrintWriter otherNumbersWriter = new PrintWriter(otherNumbersFilePath)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                int number = Integer.parseInt(line);
                if (isPalindrome(number)) {
                    palindromesWriter.println(number);
                } else {
                    otherNumbersWriter.println(number);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        sortNumbersInFile(numbersFilePath);

        System.out.println("\nСписок файлов до копирования и удаления:");
        try {
            Files.lines(Paths.get(destinationDirectory, fileListPath)).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nЦелые числа после обработки и записи в файл:");
        try {
            Files.lines(Paths.get(numbersFilePath)).map(Integer::parseInt).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nПалиндромы:");
        try {
            Files.lines(Paths.get(palindromesFilePath)).map(Integer::parseInt).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nПрочее:");
        try {
            Files.lines(Paths.get(otherNumbersFilePath)).map(Integer::parseInt).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isPalindrome(int number) {
        String numStr = Integer.toString(number);
        return numStr.equals(new StringBuilder(numStr).reverse().toString());
    }

    public static void sortNumbersInFile(String filePath) {
        List<Integer> numbers = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                numbers.add(Integer.parseInt(scanner.nextLine()));
            }
            numbers.sort(Comparator.reverseOrder());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (PrintWriter writer = new PrintWriter(filePath)) {
            for (int num : numbers) {
                writer.println(num);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
