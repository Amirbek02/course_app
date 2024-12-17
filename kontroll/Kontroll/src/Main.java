import java.util.Random;
import java.util.Scanner;


// Амираев Амирбек ИВТ(б)-1-22



public class Main {
    public static void main(String[] args) {
        String[] riddles = {
                "Что можно увидеть с закрытыми глазами?",
                "Что летает без крыльев?",
                "Что имеет корень, но не растет?",
        };
        String[] antworts = {
                "сон",
                "время",
                "математическое уравнение",
        };
        Random random = new Random();
        int randomIndex = random.nextInt(riddles.length);
        String currentRiddle = riddles[randomIndex];
        String antwort = antworts[randomIndex];

        System.out.println("Угадайте загадку: " + currentRiddle);
        Scanner scanner = new Scanner(System.in);

        firstFunction(scanner, antwort);

        System.out.println("Вы исчерпали все попытки. Неудача в разгадке.");
    }

    public static void firstFunction(Scanner scanner, String antwort) {
        for (int i = 1; i <= 3; i++) {
            System.out.print("Введите ответ (" + i + "/3): ");
            String userAnswer = scanner.nextLine();

            if (userAnswer.equalsIgnoreCase("Сдаюсь")) {
                System.out.println("Правильный ответ: " + antwort);
                System.out.println("Выход из программы.");
                System.exit(0);
            } else if (userAnswer.equals(antwort)) {
                System.out.println("Правильно!");
                break;
            } else {
                System.out.println("Неверно. Осталось попыток: " + (3 - i));
            }
        }
    }
}
