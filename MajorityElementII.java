import java.util.ArrayList;
import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Majority Element-II
Platform: TUF A2Z DSA Sheet
Topic   : Arrays
Difficulty: Medium

Approach (Boyer-Moore Voting Algorithm):
1. There can be at most two elements occurring more than n/3 times.
2. Maintain two candidates and their counts.
3. First pass:
      - Find the two potential majority candidates.
4. Second pass:
      - Count the occurrences of both candidates.
5. Return the candidates whose frequency is greater than n/3.

Time Complexity : O(n)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class MajorityElementII {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read array size
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Read array elements
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int candidate1 = 0;
        int candidate2 = 0;
        int count1 = 0;
        int count2 = 0;

        // Step 1: Find potential candidates
        for (int num : nums) {

            if (candidate1 == num) {
                count1++;
            }
            else if (candidate2 == num) {
                count2++;
            }
            else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            }
            else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            }
            else {
                count1--;
                count2--;
            }
        }

        // Step 2: Verify the candidates
        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        if (count1 > n / 3) {
            result.add(candidate1);
        }

        if (count2 > n / 3) {
            result.add(candidate2);
        }

        System.out.println(result);

        sc.close();
    }
}

/*
------------------------------------------------------------
Dry Run

Input:
[1, 2, 1, 1, 3, 2]

n = 6
n/3 = 2

First Pass:
Candidate1 = 1
Candidate2 = 2

Second Pass:
1 occurs 3 times
2 occurs 2 times

Only 1 occurs more than n/3.

Output:
[1]

Key Observation:
There can never be more than two elements
appearing more than n/3 times.

Hence, only two candidates need to be tracked.

------------------------------------------------------------
*/