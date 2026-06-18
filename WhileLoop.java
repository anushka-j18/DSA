/*Given a digit d (0 to 9), find the sum of the first 50 positive integers (integers > 0) that end with digit d.



A number ends with digit d if its last digit is d.


Example 1

Input: d = 1

Output: 12300

Explanation:

The first 50 positive integers ending with 1 are: 1, 11, 21, 31, ..., 491

Their sum is 12300.

Example 2

Input: d = 5

Output: 12500 */
import java.util.Scanner;

public class WhileLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int d = sc.nextInt();
        int sum = 0;
        int count = 0;
        int num = d;

        if (d == 0) {
            num = 10; // first positive integer ending in 0
        }

        while (count < 50) {
            sum += num;
            num += 10;
            count++;
        }

        System.out.println(sum);

        sc.close();
    }
}