import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Koko Eating Bananas

Approach:
1. The minimum possible eating speed is 1 banana/hour.
2. The maximum possible eating speed is the maximum pile size.
3. Apply Binary Search on the eating speed.
4. For every speed:
      - Calculate the total hours required to finish all piles.
      - If hours <= h, store the speed as a possible answer
        and search for a smaller speed.
      - Otherwise, search for a larger speed.
5. Return the minimum valid speed.

Time Complexity : O(n × log(maxPile))
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class KokoEatingBananas {

    // Returns total hours required at a given eating speed
    static long calculateHours(int[] nums, int speed) {

        long totalHours = 0;

        for (int bananas : nums) {

            // Equivalent to Math.ceil(bananas / speed)
            totalHours += (bananas + speed - 1) / speed;
        }

        return totalHours;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read number of piles
        int n = sc.nextInt();

        int[] nums = new int[n];

        int maximumPile = 0;

        // Read piles
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            maximumPile = Math.max(maximumPile, nums[i]);
        }

        // Read total hours
        int h = sc.nextInt();

        int low = 1;
        int high = maximumPile;
        int answer = maximumPile;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            long hours = calculateHours(nums, mid);

            if (hours <= h) {

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
nums = [7, 15, 6, 3]
h = 8

Search Space:
1 ... 15

mid = 8

Hours:
7 -> 1
15 -> 2
6 -> 1
3 -> 1

Total = 5

5 <= 8

Try smaller speed.

--------------------------------------------

mid = 4

Hours:
7 -> 2
15 -> 4
6 -> 2
3 -> 1

Total = 9

9 > 8

Need a larger speed.

--------------------------------------------

mid = 5

Hours:
7 -> 2
15 -> 3
6 -> 2
3 -> 1

Total = 8

Valid answer.

Output:
5

Key Observation:
As the eating speed increases,
the total hours required always decrease.

This monotonic property makes Binary Search applicable.

------------------------------------------------------------
*/