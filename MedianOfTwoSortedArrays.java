import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Median of Two Sorted Arrays

Approach:
1. Always apply Binary Search on the smaller array.
2. Partition both arrays such that:
      - Left half contains (m + n + 1) / 2 elements.
3. Let:
      l1 = last element of left part of arr1
      l2 = last element of left part of arr2
      r1 = first element of right part of arr1
      r2 = first element of right part of arr2
4. If:
      l1 <= r2 AND l2 <= r1
   then the correct partition is found.
5. If total length is odd:
      Median = max(l1, l2)
6. Otherwise:
      Median = (max(l1,l2) + min(r1,r2)) / 2
7. If l1 > r2, move left.
   Else move right.

Time Complexity : O(log(min(m, n)))
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read first array size
        int m = sc.nextInt();

        int[] arr1 = new int[m];

        // Read first array
        for (int i = 0; i < m; i++) {
            arr1[i] = sc.nextInt();
        }

        // Read second array size
        int n = sc.nextInt();

        int[] arr2 = new int[n];

        // Read second array
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }

        // Always binary search on the smaller array
        if (m > n) {

            int[] tempArr = arr1;
            arr1 = arr2;
            arr2 = tempArr;

            int temp = m;
            m = n;
            n = temp;
        }

        int low = 0;
        int high = m;

        while (low <= high) {

            int cut1 = low + (high - low) / 2;
            int cut2 = (m + n + 1) / 2 - cut1;

            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : arr2[cut2 - 1];

            int r1 = (cut1 == m) ? Integer.MAX_VALUE : arr1[cut1];
            int r2 = (cut2 == n) ? Integer.MAX_VALUE : arr2[cut2];

            // Correct partition found
            if (l1 <= r2 && l2 <= r1) {

                if ((m + n) % 2 == 1) {

                    System.out.println(Math.max(l1, l2));

                } else {

                    double median = (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                    System.out.println(median);
                }

                return;
            }

            // Move left
            else if (l1 > r2) {

                high = cut1 - 1;

            }

            // Move right
            else {

                low = cut1 + 1;
            }
        }

        sc.close();
    }
}

/*
------------------------------------------------------------
Dry Run

Input:

arr1 = [2,4,6]
arr2 = [1,3,5]

Merged Array:
[1,2,3,4,5,6]

Partition:

Left:
[1,2,3]

Right:
[4,5,6]

l1 = 2
l2 = 3
r1 = 4
r2 = 5

Conditions:

2 <= 5 ✓
3 <= 4 ✓

Correct partition found.

Even length:

Median =
(max(2,3) + min(4,5)) / 2

= (3 + 4) / 2

= 3.5

Output:
3.5

Key Observation:
Instead of merging both arrays,
Binary Search directly finds the correct partition
that divides the combined array into two equal halves.

------------------------------------------------------------
*/