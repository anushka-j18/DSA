import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Binary Search
Platform: TUF A2Z DSA Sheet
Topic   : Binary Search
Difficulty: Easy

Approach:
1. Initialize two pointers:
      - low = 0
      - high = n - 1
2. Find the middle element.
3. If the middle element equals the target, return its index.
4. If the target is greater, search in the right half.
5. Otherwise, search in the left half.
6. If the target is not found, return -1.

Time Complexity : O(log n)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class BinarySearch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read array size
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Read sorted array
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Read target element
        int target = sc.nextInt();

        int low = 0;
        int high = n - 1;
        int index = -1;

        while (low <= high) {

            // Find middle index
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                index = mid;
                break;
            }
            else if (nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        System.out.println(index);

        sc.close();
    }
}

/*
------------------------------------------------------------
Dry Run

Input:
nums = [-1, 0, 3, 5, 9, 12]
target = 9

low = 0
high = 5

mid = 2
nums[mid] = 3

3 < 9
Search right half

low = 3
high = 5

mid = 4
nums[mid] = 9

Target found at index 4

Output:
4

Key Observation:
Since the array is sorted, after comparing with the middle
element, one entire half of the search space can be discarded.
This reduces the search space by half in every iteration.

------------------------------------------------------------
*/