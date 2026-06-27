import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Majority Element-I
Platform: TUF A2Z DSA Sheet
Topic   : Arrays
Difficulty: Easy

Approach (Boyer-Moore Voting Algorithm):
1. Assume the first element as the majority candidate.
2. Maintain a count:
      - If count becomes 0, choose the current element as the new candidate.
      - If the current element equals the candidate, increment count.
      - Otherwise, decrement count.
3. Since the problem guarantees a majority element (> n/2),
   the final candidate is the answer.

Time Complexity : O(n)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class MajorityElement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read array size
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Read array elements
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int candidate = 0;
        int count = 0;

        // Boyer-Moore Voting Algorithm
        for (int num : nums) {

            // Choose a new candidate
            if (count == 0) {
                candidate = num;
            }

            // Update count
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        System.out.println(candidate);

        sc.close();
    }
}