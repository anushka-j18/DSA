import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Search in Rotated Sorted Array

Approach:
1. Apply Binary Search.
2. At every step, one half of the array is always sorted.
3. Check whether the left half or the right half is sorted.
4. If the target lies in the sorted half, search there.
5. Otherwise, search in the other half.
6. If the target is not found, return -1.

Time Complexity : O(log n)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read array size
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Read array elements
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Read target
        int target = sc.nextInt();

        int low = 0;
        int high = n - 1;
        int answer = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Target found
            if (nums[mid] == target) {
                answer = mid;
                break;
            }

            // Left half is sorted
            if (nums[low] <= nums[mid]) {

                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            // Right half is sorted
            else {

                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
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
nums = [4, 5, 6, 7, 0, 1, 2]
target = 0

low = 0
high = 6

mid = 3
nums[mid] = 7

Left half:
[4, 5, 6, 7] is sorted

Target is not in left half.

Search right half.

low = 4
high = 6

mid = 5
nums[mid] = 1

Left half:
[0, 1] is sorted

Target lies in left half.

high = 4

mid = 4

nums[mid] = 0

Target Found!

Output:
4

Key Observation:
In a rotated sorted array, one half is always sorted.
Identify the sorted half first, then decide whether the
target lies within it to eliminate half of the search space.

------------------------------------------------------------
*/