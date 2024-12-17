import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = 0;
        int sum = 0;
        boolean hasNumberGreaterThan10 = false;
        int a = 0; // Ввод чисел с клавиатуры

        while (true){
            int num =scanner.nextInt();
            num1=num;
            a++;
            if (num%5==0 ){
                if (num == 5){
                    break;
                }else if (sum!=0){

                    sum += num;
                }
                break;
            }
            if (num > 10) {
                sum += num;
                hasNumberGreaterThan10 = true;
            }



        }

        if (a == 1){
            System.out.println(num1);

        }else if (num1 <= 15 && num1 % 15 == 0){

            System.out.println(num1);
        }else {
            System.out.println(sum);
        }


        scanner.close();
    }
}