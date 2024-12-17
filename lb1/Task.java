import java.util.Scanner;

public class Task {
  public static void main(String[] args) {
    System.out.print("Введите число: ");
    Scanner scanner = new Scanner(System.in);
    int intValue = scanner.nextInt();
   if (intValue < 5) {
    System.out.println("Меньше 5и");
  } else if (intValue > 5) {
    System.out.println("Больше 5и");
  } else {
    System.out.println("Равно 5и");
  }
}
}

