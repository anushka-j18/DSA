import java.util.Arrays;
import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Aggressive Cows

Approach:
1. Sort the stall positions.
2. The minimum possible distance is 1.
3. The maximum possible distance is:
      last stall - first stall.
4. Apply Binary Search on the minimum distance.
5. For every distance:
      - Try placing cows greedily.
      - If all k cows can be placed, try a larger distance.
      - Otherwise, try a smaller distance.
6. The largest valid distance is the answer.

Time Complexity : O(n log n + n log(maxDistance))
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class AggressiveCows {

    // Check if k cows can be placed with at least 'distance' apart
    static boolean canPlaceCows(int[] stalls, int k, int distance) {

        int cowsPlaced = 1;
        int lastPosition = stalls[0];

        for (int i = 1; i < stalls.length; i++) {

            if (stalls[i] - lastPosition >= distance) {

                cowsPlaced++;
                lastPosition = stalls[i];

                if (cowsPlaced == k) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read number of stalls
        int n = sc.nextInt();

        // Read number of cows
        int k = sc.nextInt();

        int[] stalls = new int[n];

        // Read stall positions
        for (int i = 0; i < n; i++) {
            stalls[i] = sc.nextInt();
        }

        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[n - 1] - stalls[0];
        int answer = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canPlaceCows(stalls, k, mid)) {

                answer = mid;
                low = mid + 1;

            } else {

                high = mid - 1;
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
n = 6
k = 4

Stalls:
[0, 3, 4, 7, 10, 9]

After Sorting:
[0, 3, 4, 7, 9, 10]

Search Space:
1 ... 10

mid = 5

Place cows:
0
7

Only 2 cows.

Not possible.

--------------------------------------------

mid = 3

Place cows:
0
3
7
10

4 cows placed.

Possible.

Try a larger distance.

--------------------------------------------

mid = 4

Place cows:
0
4
9

Only 3 cows.

Not possible.

Answer = 3

Output:
3

Key Observation:
If a minimum distance 'd' is possible,
then every distance smaller than 'd' is also possible.

This monotonic property allows Binary Search
on the answer.

------------------------------------------------------------
*/