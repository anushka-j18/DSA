import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Minimum Days to Make M Bouquets

Approach:
1. If total flowers required (m × k) is greater than n,
   it is impossible to make the bouquets.
2. The answer lies between:
      - Minimum bloom day
      - Maximum bloom day
3. Apply Binary Search on the number of days.
4. For each day:
      - Count how many bouquets can be formed using
        consecutive bloomed flowers.
5. If at least m bouquets can be made,
   try to minimize the number of days.
6. Otherwise, search for a larger day.

Time Complexity : O(n × log(maxBloomDay))
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class MinimumDaysToMakeBouquets {

    // Check if it is possible to make m bouquets in 'day' days
    static boolean canMakeBouquets(int[] nums, int day, int m, int k) {

        int bouquets = 0;
        int flowers = 0;

        for (int bloomDay : nums) {

            if (bloomDay <= day) {

                flowers++;

                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }

            } else {

                flowers = 0;
            }
        }

        return bouquets >= m;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read number of roses
        int n = sc.nextInt();

        int[] nums = new int[n];

        int minimumDay = Integer.MAX_VALUE;
        int maximumDay = Integer.MIN_VALUE;

        // Read bloom days
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            minimumDay = Math.min(minimumDay, nums[i]);
            maximumDay = Math.max(maximumDay, nums[i]);
        }

        // Read m and k
        int m = sc.nextInt();
        int k = sc.nextInt();

        // Impossible case
        if ((long) m * k > n) {
            System.out.println(-1);
            return;
        }

        int low = minimumDay;
        int high = maximumDay;
        int answer = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canMakeBouquets(nums, mid, m, k)) {

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
nums = [7,7,7,7,13,11,12,7]
m = 2
k = 3

Search Space:
7 ... 13

Day = 10

Bloomed:
7 7 7 7 X X X 7

Bouquets:
(7,7,7) = 1

Only 1 bouquet

Need more days.

--------------------------------------------

Day = 12

Bloomed:
7 7 7 7 X 11 12 7

Bouquets:
(7,7,7) = 1
(11,12,7) = 1

Total = 2

Answer = 12

Key Observation:
As the number of days increases,
the number of bloomed flowers never decreases.

This monotonic property allows Binary Search
on the answer.

------------------------------------------------------------
*/