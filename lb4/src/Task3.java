import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        boolean isReversed = true;
        int prevDigit = number % 10;
        number /= 10;

        while (number != 0 && isReversed) {
            int currentDigit = number % 10;
            if (currentDigit >= prevDigit) {
                isReversed = false;
            }
            prevDigit = currentDigit;
            number /= 10;
        }

        if (isReversed) {
            System.out.println("Цифры числа идут в обратном порядке.");
        } else {
            System.out.println("Цифры числа не идут в обратном порядке.");

        }
    }
}
