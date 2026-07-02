import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Find Number of Times Array is Rotated

Approach:
1. The number of rotations equals the index of the
   minimum element in the rotated sorted array.
2. Apply Binary Search.
3. If the current search space is already sorted,
   then the minimum element is at index 'low'.
4. Otherwise, determine which half is sorted.
5. Search in the unsorted half while keeping track
   of the minimum element's index.

Time Complexity : O(log n)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class NumberOfRotations {

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

        int minIndex = 0;
        int minElement = Integer.MAX_VALUE;

        while (low <= high) {

            // Current part is already sorted
            if (nums[low] <= nums[high]) {

                if (nums[low] < minElement) {
                    minElement = nums[low];
                    minIndex = low;
                }

                break;
            }

            int mid = low + (high - low) / 2;

            // Left half is sorted
            if (nums[low] <= nums[mid]) {

                if (nums[low] < minElement) {
                    minElement = nums[low];
                    minIndex = low;
                }

                low = mid + 1;
            }

            // Right half is sorted
            else {

                if (nums[mid] < minElement) {
                    minElement = nums[mid];
                    minIndex = mid;
                }

                high = mid - 1;
            }
        }

        System.out.println(minIndex);

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

Minimum = 4
Index = 0

Search right half

--------------------------------------------

low = 4
high = 7

Current search space:
[0, 1, 2, 3]

Already sorted

Minimum = 0
Index = 4

Output:
4

--------------------------------------------

Input:
nums = [3, 4, 5, 1, 2]

Output:
3

Key Observation:
The number of rotations is exactly the index of the
minimum element in the rotated sorted array.

------------------------------------------------------------
*/