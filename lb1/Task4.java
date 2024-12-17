import java.util.Scanner;

public class Task4 {
  public static void main(String[] args) throws java.io.IOException {
        Scanner scanner = new Scanner(System.in);
       
        System.out.print("Выберите вариант задачи а и б  ");
      boolean boolean1 = false;
      char var=scanner.next().charAt(0);
      boolean1=var== 'b'? true : false;
      
        
        System.out.print("Введите первый символ: ");
        char firstChar = scanner.next().charAt(0);
        System.out.print("Введите второй символ: ");
        char secondChar = scanner.next().charAt(0);
        scanner = new Scanner(System.in);
        System.out.print("Введите предложение: ");
        String sentence = scanner.nextLine();
        char[] arr = sentence.toCharArray();

        
       
        for(int i = 0; i<arr.length; i++) {
          if (arr[i] == firstChar) {
            arr[i] = secondChar;
            if (boolean1 == true) {
              break;
        } 
        }
       }

       System.out.println("Результат замены: " + new String(arr));


  }
}

