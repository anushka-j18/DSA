import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Floor and Ceil in a Sorted Array

Approach:
1. Use Binary Search to find the floor:
      - Floor is the largest element <= x.
2. Use another Binary Search to find the ceil:
      - Ceil is the smallest element >= x.
3. If floor or ceil does not exist, return -1.

Time Complexity : O(log n)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class FloorAndCeil {

    // Function to find floor
    static int findFloor(int[] nums, int x) {

        int low = 0;
        int high = nums.length - 1;
        int floor = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] <= x) {
                floor = nums[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return floor;
    }

    // Function to find ceil
    static int findCeil(int[] nums, int x) {

        int low = 0;
        int high = nums.length - 1;
        int ceil = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] >= x) {
                ceil = nums[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ceil;
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
        int x = sc.nextInt();

        int floor = findFloor(nums, x);
        int ceil = findCeil(nums, x);

        System.out.println(floor + " " + ceil);

        sc.close();
    }
}

/*
------------------------------------------------------------
Dry Run

Input:
nums = [3, 4, 4, 7, 8, 10]
x = 5

Finding Floor:

mid = 2 -> 4 <= 5
floor = 4

mid = 4 -> 8 > 5
Search left

mid = 3 -> 7 > 5
Search left

Final Floor = 4

--------------------------------------------

Finding Ceil:

mid = 2 -> 4 < 5
Search right

mid = 4 -> 8 >= 5
ceil = 8

mid = 3 -> 7 >= 5
ceil = 7

Final Ceil = 7

Output:
4 7

Key Observation:
Floor searches for the last value <= x.
Ceil searches for the first value >= x.

------------------------------------------------------------
*/