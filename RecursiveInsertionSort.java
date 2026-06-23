import java.util.Arrays;
import java.util.Scanner;

public class RecursiveInsertionSort {

    static void insertionSort(int[] arr, int n) {
        if (n <= 1) {
            return;
        }

        insertionSort(arr, n - 1);

        int last = arr[n - 1];
        insert(arr, n - 2, last);
    }

    static void insert(int[] arr, int j, int key) {
        if (j < 0 || arr[j] <= key) {
            arr[j + 1] = key;
            return;
        }

        arr[j + 1] = arr[j];
        insert(arr, j - 1, key);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        insertionSort(nums, n);

        System.out.println(Arrays.toString(nums));

        sc.close();
    }
}