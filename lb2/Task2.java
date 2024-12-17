import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите значение n: ");
        int n = scanner.nextInt();
        double sum = 0;

        for (int i = 0; i < n; i++) {
            double c =  (Math.pow(8, i) - Math.pow(3, i + 1)) / Math.pow(10, i);
            sum += c;
        }

        System.out.println(sum);
    }
}
