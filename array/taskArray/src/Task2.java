public class Task2 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        modifyArray(array);

        System.out.print("Измененный массив: ");
        printArray(array);
    }
    public static void modifyArray(int[] arr) {
        int firstEven = -1;

        for (int num : arr) {
            if (num % 2 == 0) {
                firstEven = num;
                break;
            }
        }
        if (firstEven == -1) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                arr[i] += firstEven;
            }
        }
    }
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
