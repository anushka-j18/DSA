import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Find Minimum in Rotated Sorted Array

Approach:
1. Apply Binary Search.
2. If the current subarray is already sorted, then
   nums[low] is the minimum element.
3. Otherwise, determine which half is sorted.
4. The minimum cannot lie in the sorted half (except its
   first element, which is already considered), so search
   in the unsorted half.
5. Keep updating the minimum element encountered.

Time Complexity : O(log n)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read array size
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Read array elements
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int low = 0;
        int high = n - 1;

        int minimum = Integer.MAX_VALUE;

        while (low <= high) {

            // Current part is already sorted
            if (nums[low] <= nums[high]) {
                minimum = Math.min(minimum, nums[low]);
                break;
            }

            int mid = low + (high - low) / 2;

            // Left half is sorted
            if (nums[low] <= nums[mid]) {

                minimum = Math.min(minimum, nums[low]);
                low = mid + 1;

            }

            // Right half is sorted
            else {

                minimum = Math.min(minimum, nums[mid]);
                high = mid - 1;
            }
        }

        System.out.println(minimum);

        sc.close();
    }
}

/*
------------------------------------------------------------
Dry Run

Input:
nums = [4, 5, 6, 7, 0, 1, 2, 3]

low = 0
high = 7

mid = 3

Left half:
[4, 5, 6, 7] is sorted

minimum = 4

Search right half.

--------------------------------------------

low = 4
high = 7

Current subarray:
[0, 1, 2, 3]

Already sorted.

minimum = min(4, 0) = 0

Output:
0

--------------------------------------------

Input:
nums = [3, 4, 5, 1, 2]

Output:
1

Key Observation:
At every step, one half of the array is sorted.
The minimum element always lies in the unsorted half,
unless the current search space is already sorted.

------------------------------------------------------------
*/