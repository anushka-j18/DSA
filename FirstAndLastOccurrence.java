import java.util.Arrays;
import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Find First and Last Position of Element in Sorted Array

Approach:
1. Use Binary Search twice.
2. First Binary Search:
      - Find the first occurrence of the target.
3. Second Binary Search:
      - Find the last occurrence of the target.
4. If the target is not present, return [-1, -1].

Time Complexity : O(log n)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class FirstAndLastOccurrence {

    // Find first occurrence
    static int findFirst(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        int first = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                first = mid;
                high = mid - 1;
            } 
            else if (nums[mid] < target) {
                low = mid + 1;
            } 
            else {
                high = mid - 1;
            }
        }

        return first;
    }

    // Find last occurrence
    static int findLast(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        int last = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                last = mid;
                low = mid + 1;
            } 
            else if (nums[mid] < target) {
                low = mid + 1;
            } 
            else {
                high = mid - 1;
            }
        }

        return last;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read array size
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Read sorted array
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Read target
        int target = sc.nextInt();

        int first = findFirst(nums, target);
        int last = findLast(nums, target);

        System.out.println(Arrays.toString(new int[]{first, last}));

        sc.close();
    }
}

/*
------------------------------------------------------------
Dry Run

Input:
nums = [5, 7, 7, 8, 8, 10]
target = 8

First Occurrence:
low = 0, high = 5

mid = 2 -> 7 < 8
Search right

mid = 4 -> 8 found
first = 4
Search left

mid = 3 -> 8 found
first = 3

First = 3

--------------------------------------------

Last Occurrence:

mid = 2 -> 7 < 8
Search right

mid = 4 -> 8 found
last = 4
Search right

mid = 5 -> 10 > 8
Search left

Last = 4

Output:
[3, 4]

Key Observation:
To find the first occurrence, continue searching
towards the left after finding the target.

To find the last occurrence, continue searching
towards the right after finding the target.

------------------------------------------------------------
*/