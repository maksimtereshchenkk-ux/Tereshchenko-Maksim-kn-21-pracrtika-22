import java.util.*;
import java.time.LocalTime;
import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Розмір масиву: ");
        int n = Integer.parseInt(sc.nextLine());
        int[] original = generateArray(n);

        int[] arrQuick = Arrays.copyOf(original, n);

        System.out.println("Quick Sort: " + measureTime(() -> quickSort(arrQuick, 0, n - 1)));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
            }
        }
        int temp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = temp;
        return i + 1;
    }
    public static String measureTime(Runnable sortMethod) {
        LocalTime start = LocalTime.now();
        sortMethod.run();
        LocalTime end = LocalTime.now();
        return Duration.between(start, end).toMillis() + " мс";
    }

    public static int[] generateArray(int n) {
        Random r = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = r.nextInt(2000) - 1000;
        return arr;
    }
}