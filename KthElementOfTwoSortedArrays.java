import java.util.Scanner;

/*
------------------------------------------------------------
Problem : K-th Element of Two Sorted Arrays

Approach:
1. Always apply Binary Search on the smaller array.
2. Partition both arrays such that:
      - The left partitions together contain exactly k elements.
3. Let:
      l1 = last element in left part of first array
      l2 = last element in left part of second array
      r1 = first element in right part of first array
      r2 = first element in right part of second array
4. If:
      l1 <= r2 AND l2 <= r1
   then the correct partition is found.
5. The k-th element is:
      max(l1, l2)
6. If l1 > r2, move left.
   Else move right.

Time Complexity : O(log(min(m, n)))
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class KthElementOfTwoSortedArrays {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read first array size
        int m = sc.nextInt();

        int[] a = new int[m];

        // Read first array
        for (int i = 0; i < m; i++) {
            a[i] = sc.nextInt();
        }

        // Read second array size
        int n = sc.nextInt();

        int[] b = new int[n];

        // Read second array
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        // Read k
        int k = sc.nextInt();

        // Always binary search on the smaller array
        if (m > n) {

            int[] tempArray = a;
            a = b;
            b = tempArray;

            int temp = m;
            m = n;
            n = temp;
        }

        int low = Math.max(0, k - n);
        int high = Math.min(k, m);

        while (low <= high) {

            int cut1 = low + (high - low) / 2;
            int cut2 = k - cut1;

            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : a[cut1 - 1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : b[cut2 - 1];

            int r1 = (cut1 == m) ? Integer.MAX_VALUE : a[cut1];
            int r2 = (cut2 == n) ? Integer.MAX_VALUE : b[cut2];

            // Correct partition
            if (l1 <= r2 && l2 <= r1) {

                System.out.println(Math.max(l1, l2));
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

a = [2,3,6,7,9]
b = [1,4,8,10]

k = 5

Partition:

Left:
[2,3,6]
[1,4]

Right:
[7,9]
[8,10]

l1 = 6
l2 = 4
r1 = 7
r2 = 8

Conditions:

6 <= 8 ✓
4 <= 7 ✓

Correct partition found.

Answer:

max(6,4) = 6

Output:
6

--------------------------------------------

Input:

a = [100,112,256,349,770]
b = [72,86,113,119,265,445,892]

k = 7

Answer:
256

Key Observation:
Instead of merging both arrays,
Binary Search finds a partition where exactly
k elements lie on the left side.

The largest element on the left side is the
k-th smallest element.

------------------------------------------------------------
*/