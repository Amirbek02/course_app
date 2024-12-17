public class Main {
    public static void main(String[] args) {
        int[] arrayA = {1, 2, 3, 4, 5};
        int[] arrayB = generateNewArray(arrayA);

        System.out.print("Исходный массив A: ");
        printArray(arrayA);

        System.out.print("Новый массив B: ");
        printArray(arrayB);
    }

    public static int[] generateNewArray(int[] a) {
        int n = a.length;
        int[] b = new int[n];

        for (int k = 0; k < n; k++) {
            b[k] = (int) calculateAverage(a, k, n - 1);

        }


        return b;
    }

    public static double calculateAverage(int[] arr, int startIndex, int endIndex) {
        int sum = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            sum += arr[i];

        }
        for(int value : arr) {
            System.out.println(value);
        }
        System.out.println((double) sum / (endIndex - startIndex + 1));
        return (double) sum / (endIndex - startIndex + 1);
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
