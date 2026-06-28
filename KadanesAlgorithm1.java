import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Kadane's Algorithm
Platform: TUF A2Z DSA Sheet
Topic   : Arrays
Difficulty: Medium

Approach:
1. Traverse the array while maintaining the current subarray sum.
2. Add the current element to the running sum.
3. Update the maximum sum whenever a larger sum is found.
4. If the running sum becomes negative, discard it by resetting
   it to 0, since a negative sum cannot contribute to a maximum sum.
5. The maximum sum obtained during traversal is the answer.

Time Complexity : O(n)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class KadanesAlgorithm1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read the size of the array
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Read array elements
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int currentSum = 0;
        int maximumSum = Integer.MIN_VALUE;

        // Traverse the array
        for (int num : nums) {

            // Extend the current subarray
            currentSum += num;

            // Update the maximum subarray sum
            if (currentSum > maximumSum) {
                maximumSum = currentSum;
            }

            // Start a new subarray if current sum becomes negative
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        System.out.println(maximumSum);

        sc.close();
    }
}

/*
------------------------------------------------------------
Dry Run

Input:
[2, 3, 5, -2, 7, -4]

Current Sum    Maximum Sum

2              2
5              5
10             10
8              10
15             15
11             15

Answer = 15

Key Observation:
If the current running sum becomes negative,
it cannot increase the sum of any future subarray.
Hence, reset it to 0 and start a new subarray.

------------------------------------------------------------
*/