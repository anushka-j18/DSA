import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Single Element in a Sorted Array

Approach:
1. Handle edge cases:
      - If the array has only one element.
      - If the first element is unique.
      - If the last element is unique.
2. Apply Binary Search on the remaining elements.
3. Check whether mid is the single element:
      nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]
4. Observe the pairing pattern:
      - Before the single element:
            Even index -> First occurrence
            Odd index  -> Second occurrence
      - After the single element:
            Pattern gets reversed.
5. Decide which half to search based on the index parity.

Time Complexity : O(log n)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class SingleElementInSortedArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read array size
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Read sorted array
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Edge Case: Only one element
        if (n == 1) {
            System.out.println(nums[0]);
            return;
        }

        // Edge Case: First element is unique
        if (nums[0] != nums[1]) {
            System.out.println(nums[0]);
            return;
        }

        // Edge Case: Last element is unique
        if (nums[n - 1] != nums[n - 2]) {
            System.out.println(nums[n - 1]);
            return;
        }

        int low = 1;
        int high = n - 2;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Unique element found
            if (nums[mid] != nums[mid - 1] &&
                nums[mid] != nums[mid + 1]) {

                System.out.println(nums[mid]);
                return;
            }

            // Left half is valid
            if ((mid % 2 == 0 && nums[mid] == nums[mid + 1]) ||
                (mid % 2 == 1 && nums[mid] == nums[mid - 1])) {

                low = mid + 1;
            }

            // Search left half
            else {
                high = mid - 1;
            }
        }

        sc.close();
    }
}

/*
------------------------------------------------------------
Dry Run

Input:
nums = [1,1,2,2,3,3,4,5,5,6,6]

low = 1
high = 9

mid = 5

nums[5] = 3

Pair is correct.
Unique lies on the right.

low = 6

mid = 7

nums[7] = 5

Pair is broken.

Search left.

mid = 6

nums[6] = 4

Unique element found.

Output:
4

--------------------------------------------

Input:
nums = [1,1,3,5,5]

Output:
3

Key Observation:
Before the unique element,
pairs start at even indices.

After the unique element,
pairs start at odd indices.

This property enables Binary Search.

------------------------------------------------------------
*/