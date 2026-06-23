import java.util.Arrays;
import java.util.Scanner;

public class RecursiveBubbleSort {

    static void bubbleSort(int[] arr, int n) {
        // Base case
        if (n == 1) {
            return;
        }

        // One pass of bubble sort
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }

        // Recursive call for remaining array
        bubbleSort(arr, n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        bubbleSort(nums, n);

        System.out.println(Arrays.toString(nums));

        sc.close();
    }
}