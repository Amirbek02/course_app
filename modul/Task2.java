import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите свой пароль: ");
        String password = sc.next();

        while (password.length() < 6) {
            System.out.println("Пароль слишком короткий. Минимальная длина пароля - 6!");
            System.out.print("Введите пароль ещё раз: ");
            password = sc.next();
        }

        int A = Power(password);
        int L = password.length();
        System.out.println("Мощность пароля A: " + A);
        System.out.println("Длина пароля L: " + L);

        long S = (long) Math.pow(A, L);
        System.out.println("Число возможных паролей S: " + S);

        System.out.print("Введите скорость перебора паролей злоумышленником (паролей в день) V: ");
        int y = sc.nextInt();
        int V = y * 24 * 60;

        System.out.print("Максимальный срок действия пароля (в днях) T: ");
        int x = sc.nextInt();
        int T = x * 24 * 60; 
        System.out.println("Срок действия пароля в минутах T: " + T);

        double P = (double) (V * T) / S;
        System.out.println("Вероятность подбора пароля P: " + P);
    }

    public static int Power(String password) {
        int A = 0;

        if (password.matches(".[A-Z].")) {
            A += 26; 
        }
        if (password.matches(".[a-z].")) {
            A += 26; 
        }
        if (password.matches(".[0-9].")) {
            A += 10; 
        }
        if (password.matches(".[А-Я].")) {
            A += 33; 
        }
        if (password.matches(".[а-я].")) {
            A += 33; 
        }
        return A;
    }
}