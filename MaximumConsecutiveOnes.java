import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Maximum Consecutive Ones
Platform: TUF A2Z DSA Sheet
Topic   : Arrays
Difficulty: Easy

Approach:
1. Traverse the array once.
2. Maintain a counter for consecutive 1s.
3. Increment the counter when a 1 is found.
4. Reset the counter to 0 when a 0 is encountered.
5. Keep updating the maximum count.

Time Complexity : O(n)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class MaximumConsecutiveOnes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read array size
        int n = sc.nextInt();
        int[] nums = new int[n];

        // Read array elements
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int consecutiveOnes = 0;
        int maximumOnes = 0;

        // Traverse the array
        for (int num : nums) {

            // Count consecutive 1s
            if (num == 1) {
                consecutiveOnes++;

                // Update maximum streak found so far
                maximumOnes = Math.max(maximumOnes, consecutiveOnes);
            }
            // Reset count when a 0 is encountered
            else {
                consecutiveOnes = 0;
            }
        }

        System.out.println(maximumOnes);

        sc.close();
    }
}