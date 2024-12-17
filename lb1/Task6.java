import java.util.Scanner;

public class Task6 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Введите баллы: ");
    int points = scanner.nextInt();

    if(points >= 87 && points <= 100) {
      System.out.println("A Отлично!");
    } else if (points >= 80 && points <= 86) {
System.out.println("B Очень хорошо!");
    } else if (points >= 74 && points <= 79) {
      System.out.println("C Хорошо!");
    } else if (points >= 68 && points <= 73) {
      System.out.println("D Удовлетворительно!");
    } else if (points >= 61 && points <= 67) {
      System.out.println("E «посредственно» – результат отвечает минимальным требованиям");
    } else if (points >= 41 && points <= 60) {
      System.out.println("FX«неудовлетворительно»– для получения зачета необходимо сдать минимум");
    } else if (points >= 0 && points <= 40) {
      System.out.println("F «неудовлетворительно»– для получения зачета необходимо сдать минимум");
    } else {
      System.out.println("Ошибка: введите число от 0 до 100");
    }
  }
}
