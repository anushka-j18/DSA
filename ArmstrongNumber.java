import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int original = n;

        // Count digits
        int digits = 0;
        int temp = n;

        while (temp > 0) {
            digits++;
            temp /= 10;
        }

        // Calculate Armstrong sum
        int sum = 0;
        temp = n;

        while (temp > 0) {
            int digit = temp % 10;
            sum += (int) Math.pow(digit, digits);
            temp /= 10;
        }

        System.out.println(sum == original);

        sc.close();
    }
}