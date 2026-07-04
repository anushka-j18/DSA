import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Find the Smallest Divisor Given a Threshold

Approach:
1. The smallest possible divisor is 1.
2. The largest possible divisor is the maximum element
   in the array.
3. Apply Binary Search on the divisor.
4. For each divisor:
      - Calculate the sum of ceil(nums[i] / divisor)
        for every element.
5. If the sum is less than or equal to the threshold,
   store the divisor as a possible answer and search
   for a smaller divisor.
6. Otherwise, search for a larger divisor.

Time Complexity : O(n × log(maxElement))
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class SmallestDivisor {

    // Calculate the sum after division using the given divisor
    static long calculateSum(int[] nums, int divisor) {

        long sum = 0;

        for (int num : nums) {

            // Equivalent to Math.ceil(num / divisor)
            sum += (num + divisor - 1) / divisor;
        }

        return sum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read array size
        int n = sc.nextInt();

        int[] nums = new int[n];

        int maximum = Integer.MIN_VALUE;

        // Read array elements
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            maximum = Math.max(maximum, nums[i]);
        }

        // Read threshold
        int limit = sc.nextInt();

        int low = 1;
        int high = maximum;
        int answer = maximum;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            long sum = calculateSum(nums, mid);

            if (sum <= limit) {

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
limit = 8

Search Space:
1 ... 5

mid = 3

Ceil Division:
1/3 = 1
2/3 = 1
3/3 = 1
4/3 = 2
5/3 = 2

Sum = 7

7 <= 8

Possible answer = 3

Search left.

--------------------------------------------

mid = 2

Ceil Division:
1 1 2 2 3

Sum = 9

9 > 8

Need a larger divisor.

Final Answer = 3

Key Observation:
As the divisor increases,
the total sum of ceiling divisions never increases.

This monotonic property allows Binary Search
on the answer.

------------------------------------------------------------
*/