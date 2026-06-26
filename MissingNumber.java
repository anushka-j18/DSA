import java.util.Scanner;

public class MissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int totalSum = n * (n + 1) / 2;
        int arraySum = 0;

        for (int num : nums) {
            arraySum += num;
        }

        System.out.println(totalSum - arraySum);

        sc.close();
    }
}