import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Leaders in an Array
Platform: TUF A2Z DSA Sheet
Topic   : Arrays
Difficulty: Medium

Approach:
1. Traverse the array from right to left.
2. Keep track of the maximum element seen so far.
3. If the current element is greater than the maximum,
   it is a leader.
4. Store all leaders and reverse the list at the end
   to restore the original order.

Time Complexity : O(n)
Space Complexity: O(n)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class LeadersInArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read array size
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Read array elements
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        ArrayList<Integer> leaders = new ArrayList<>();

        int maximum = Integer.MIN_VALUE;

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Current element is greater than every element to its right
            if (nums[i] > maximum) {
                leaders.add(nums[i]);
                maximum = nums[i];
            }
        }

        // Reverse to restore original order
        Collections.reverse(leaders);

        System.out.println(leaders);

        sc.close();
    }
}

/*
------------------------------------------------------------
Dry Run

Input:
[1, 2, 5, 3, 1, 2]

Traverse from right:

2 -> Leader
1 -> Not Leader
3 -> Leader
5 -> Leader
2 -> Not Leader
1 -> Not Leader

Collected:
[2, 3, 5]

Reverse:
[5, 3, 2]

Answer:
[5, 3, 2]

Key Observation:
A leader must be greater than every element on its right.
Hence, traversing from right while maintaining the maximum
element seen so far gives the optimal solution.

------------------------------------------------------------
*/