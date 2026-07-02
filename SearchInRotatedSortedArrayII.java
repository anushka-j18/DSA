import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Search in Rotated Sorted Array II

Approach:
1. Apply Binary Search.
2. If nums[mid] equals the target, return true.
3. If nums[low], nums[mid], and nums[high] are equal,
   shrink the search space by incrementing low and
   decrementing high.
4. Otherwise, determine which half is sorted.
5. Check if the target lies in the sorted half.
6. Continue searching accordingly.
7. If the target is not found, return false.

Time Complexity :
- Average Case : O(log n)
- Worst Case   : O(n) (due to duplicates)

Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class SearchInRotatedSortedArrayII {

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

        boolean found = false;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Target found
            if (nums[mid] == target) {
                found = true;
                break;
            }

            // Handle duplicates
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
            }

            // Left half is sorted
            else if (nums[low] <= nums[mid]) {

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

        System.out.println(found);

        sc.close();
    }
}

/*
------------------------------------------------------------
Dry Run

Input:
nums = [7, 8, 1, 2, 3, 3, 3, 4, 5, 6]
target = 3

low = 0
high = 9

mid = 4

nums[mid] = 3

Target found.

Output:
true

--------------------------------------------

Input:
nums = [2, 5, 6, 0, 0, 1, 2]
target = 3

Duplicates may force us to shrink the search space.

Eventually the search ends without finding the target.

Output:
false

Key Observation:
With duplicates, it may become impossible to determine
which half is sorted when:

nums[low] == nums[mid] == nums[high]

In this case, shrink the search space by moving
both pointers inward.

------------------------------------------------------------
*/