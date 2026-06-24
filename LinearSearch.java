import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        int index = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                index = i;
                break;
            }
        }

        System.out.println(index);

        sc.close();
    }
}