import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Kadane's Algorithm
Platform: TUF A2Z DSA Sheet
Topic   : Arrays
Difficulty: Medium

Approach:
1. Traverse the array while maintaining the sum of the current subarray.
2. Add the current element to the running sum.
3. Update the maximum sum whenever a larger sum is found.
4. If the running sum becomes negative, discard it and start a new subarray.
5. The maximum sum encountered during traversal is the answer.

Time Complexity : O(n)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class KadanesAlgorithm {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read array size
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Read array elements
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int currentSum = 0;
        int maximumSum = Integer.MIN_VALUE;

        // Apply Kadane's Algorithm
        for (int num : nums) {

            // Extend the current subarray
            currentSum += num;

            // Update the maximum sum found so far
            maximumSum = Math.max(maximumSum, currentSum);

            // If current sum becomes negative, start a new subarray
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

Why reset when currentSum < 0?
A negative running sum can never help in obtaining a larger
subarray sum in the future, so we discard it and start fresh.
------------------------------------------------------------
*/