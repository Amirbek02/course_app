import java.util.ArrayList;
import java.util.Arrays;

public class task4 {
    public static void main(String[] args) {
        int[] array = {1, -2, 3, -4, 5};
        int[] newArray = insertZeroAfterNegative(array);

        System.out.print("Исходный массив: ");
        printArray(array);

        System.out.print("Новый массив: ");
        printArray(newArray);
    }

    public static int[] insertZeroAfterNegative(int[] arr) {
        ArrayList<Integer> resultList = new ArrayList<>();

        for (int num : arr) {
            resultList.add(num);
            if (num < 0) {
                resultList.add(0);
            }
        }
        int[] newArray = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            newArray[i] = resultList.get(i);
        }

        return newArray;
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}


