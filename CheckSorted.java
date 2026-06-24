import java.util.Scanner;

public class CheckSorted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        boolean isSorted = true;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                isSorted = false;
                break;
            }
        }

        System.out.println(isSorted);

        sc.close();
    }
}