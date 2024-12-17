public class Task3 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 5, 6, 7};
        replace(array);
        System.out.print("Измененный массив: ");
        printArray(array);
    }
    public static void replace(int[] arr) {
        int n = arr.length;

        if (n == 0) {
            return;
        }
        int[] newArray = new int[n];
        for (int i = 0; i < n; i++) {
            int sum = arr[i];
            int count = 1;
            if (i > 0) {
                sum += arr[i - 1];
                count++;
            }
            if (i < n - 1) {
                sum += arr[i + 1];
                count++;
            }
            newArray[i] = sum / count;
        }

        System.arraycopy(newArray, 0, arr, 0, n);
    }
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

