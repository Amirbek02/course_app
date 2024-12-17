import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите возраст: ");
        int age = scanner.nextInt();

        if (age < 0) {
            System.out.println("Ошибка: введите положительное число");

        } else if(age == 0) {
            System.out.println("Новорожденный");
        } else if (age < 13) {
            System.out.println("Ребенок");
        } else if (age >= 13 && age <= 19) {
            System.out.println("Подросток");
        } else if (age >= 20 && age <= 60) {
            System.out.println("Взрослый");
        } else {
            System.out.println("Пожилой человек");
        }
    }
}
