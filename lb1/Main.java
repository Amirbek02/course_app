import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите номер месяца: ");
        int month = scanner.nextInt();
        System.out.print("Введите название месяца: ");
        String monthString = scanner.next();
        System.out.print("Введите год: ");
        int year = scanner.nextInt();
        int daysInMonth = 0;

        if(month == 1 && monthString == "Январь"){
            System.out.println("Январь");
            daysInMonth = 31;

        } else if (month == 2 || monthString == "Февраль") {
          System.out.println("Февраль");
                daysInMonth = (((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0)) ? 29 : 28;
        } else if (month == 3 || monthString =="Март") {
          System.out.println("Март");
                daysInMonth = 31;
          
        }else if (month == 4 || monthString == "Апрель") {
          System.out.println("Апрель");
          daysInMonth = 30;
          
        }else if (month == 5 || monthString=="Май") {
          System.out.println("Май");
          daysInMonth = 31;
          
        }else if (month == 6 || monthString=="Июнь") {
          System.out.println("Июнь");
          daysInMonth = 30;
          
        }else if (month == 7 || monthString=="Июль") {
          System.out.println("Июль");
          daysInMonth = 31;
          
        }else if (month == 8 || monthString =="Август") {
          System.out.println("Август");
          daysInMonth = 31;
          
        }else if (month == 9 || monthString == "Сентябрь") {
          System.out.println("Сентябрь");
          daysInMonth = 30;
          
        }else if (month == 10 || monthString == "Октябрь") {
          System.out.println("Октябрь");
                daysInMonth = 31;
          
        }else if (month == 11 || monthString == "Ноябрь") {
          System.out.println("Ноябрь");
                daysInMonth = 30;
          
        } else if (month ==11 || monthString == "Декабрь") {
          
                System.out.println("Декабрь");
                daysInMonth = 31;
        } else {
          System.out.println("Ошибка: введите число от 1 до 12");
        }
        System.out.println("Количество дней в месяце: " + daysInMonth);
    }
}
