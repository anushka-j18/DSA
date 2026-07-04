import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Split Array - Largest Sum

Approach:
1. The minimum possible largest subarray sum is the
   maximum element in the array.
2. The maximum possible largest subarray sum is the
   sum of all array elements.
3. Apply Binary Search on the answer.
4. For every candidate sum:
      - Greedily split the array into subarrays such
        that no subarray sum exceeds the candidate.
      - Count the number of subarrays formed.
5. If the number of subarrays is less than or equal
   to k, try a smaller largest sum.
6. Otherwise, increase the candidate sum.
7. The smallest valid largest sum is the answer.

Time Complexity : O(n × log(sum of array))
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class SplitArrayLargestSum {

    // Returns the number of subarrays required
    static int countSubarrays(int[] nums, int maxSum) {

        int subarrays = 1;
        int currentSum = 0;

        for (int num : nums) {

            if (currentSum + num <= maxSum) {

                currentSum += num;

            } else {

                subarrays++;
                currentSum = num;
            }
        }

        return subarrays;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read array size
        int n = sc.nextInt();

        int[] nums = new int[n];

        int maxElement = 0;
        int totalSum = 0;

        // Read array elements
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            maxElement = Math.max(maxElement, nums[i]);
            totalSum += nums[i];
        }

        // Read k
        int k = sc.nextInt();

        int low = maxElement;
        int high = totalSum;
        int answer = totalSum;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int subarrays = countSubarrays(nums, mid);

            if (subarrays <= k) {

                answer = mid;
                high = mid - 1;

            } else {

                low = mid + 1;
            }
        }

        System.out.println(answer);

        sc.close();
    }
}

/*
------------------------------------------------------------
Dry Run

Input:
nums = [1, 2, 3, 4, 5]
k = 3

Search Space:
5 ... 15

mid = 10

Subarrays:
[1,2,3,4]
[5]

Total = 2

Possible.

Try smaller answer.

--------------------------------------------

mid = 7

Subarrays:
[1,2,3]
[4]
[5]

Total = 3

Possible.

Try smaller answer.

--------------------------------------------

mid = 6

Subarrays:
[1,2,3]
[4]
[5]

Largest Sum = 6

Possible.

--------------------------------------------

mid = 5

Subarrays:
[1,2]
[3]
[4]
[5]

Total = 4

Not possible.

Answer = 6

Output:
6

Key Observation:
If a maximum subarray sum is feasible,
then every larger maximum sum is also feasible.

This monotonic property allows Binary Search
on the answer.

------------------------------------------------------------
*/