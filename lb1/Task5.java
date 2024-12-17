import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите номер месяца: ");
        int month = scanner.nextInt();
        System.out.print("Введите год: ");
        int year = scanner.nextInt();
        int daysInMonth = 0;

        switch (month) {
            case 1:
                System.out.println("Январь");
                daysInMonth = 31;
                break;
            case 2:
                System.out.println("Февраль");
                daysInMonth = (((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0)) ? 29 : 28;
                break;
            case 3:
                System.out.println("Март");
                daysInMonth = 31;
                break;
            case 4:
                System.out.println("Апрель");
                daysInMonth = 30;
                break;
            case 5:
                System.out.println("Май");
                daysInMonth = 31;
                break;
            case 6:
                System.out.println("Июнь");
                daysInMonth = 30;
                break;
            case 7:
                System.out.println("Июль");
                daysInMonth = 31;
                break;
            case 8:
                System.out.println("Август");
                daysInMonth = 31;
                break;
            case 9:
                System.out.println("Сентябрь");
                daysInMonth = 30;
                break;
            case 10:
                System.out.println("Октябрь");
                daysInMonth = 31;
                break;
            case 11:
                System.out.println("Ноябрь");
                daysInMonth = 30;
                break;
            case 12:
                System.out.println("Декабрь");
                daysInMonth = 31;
                break;
            default:
                System.out.println("Ошибка: введите число от 1 до 12");
                break;
        }
        
        System.out.println("Количество дней в месяце: " + daysInMonth);

    }
}
