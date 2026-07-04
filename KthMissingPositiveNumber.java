import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Kth Missing Positive Number

Approach:
1. For every index i, the number of missing positive
   integers before arr[i] is:
        missing = arr[i] - (i + 1)
2. Apply Binary Search to find the first index where
   missing >= k.
3. After the search:
      - low represents the number of array elements
        before the kth missing number.
4. The answer is:
        low + k

Time Complexity : O(log n)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class KthMissingPositiveNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read array size
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Read sorted array
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Read k
        int k = sc.nextInt();

        int low = 0;
        int high = n - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Missing numbers before arr[mid]
            int missing = arr[mid] - (mid + 1);

            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(low + k);

        sc.close();
    }
}

/*
------------------------------------------------------------
Dry Run

Input:
arr = [3, 5, 7, 10]
k = 6

Index    Value    Missing
0         3          2
1         5          3
2         7          4
3         10         6

Binary Search:

mid = 1
missing = 3 < 6

Search right.

mid = 2
missing = 4 < 6

Search right.

mid = 3
missing = 6 >= 6

Search left.

Loop ends.

low = 3

Answer = low + k
       = 3 + 6
       = 9

Output:
9

Key Observation:
The number of missing integers before index i is:

arr[i] - (i + 1)

This value increases monotonically, making Binary Search
applicable.

------------------------------------------------------------
*/