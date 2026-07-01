import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Search Insert Position

Approach:
1. Apply Binary Search on the sorted array.
2. If the target is found, return its index.
3. If not found, the insertion position will be the first
   index where nums[i] >= target.
4. Maintain an answer initialized to n (array size).
5. Return the answer after the search.

Time Complexity : O(log n)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class SearchInsertPosition {

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

        int low = 0;
        int high = n - 1;
        int answer = n;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                System.out.println(mid);
                sc.close();
                return;
            }

            if (nums[mid] > target) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
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
nums = [1, 3, 5, 6]
target = 5

low = 0
high = 3

mid = 1
nums[mid] = 3

3 < 5
Search right half

low = 2
high = 3

mid = 2
nums[mid] = 5

Target found.

Output:
2

--------------------------------------------

Input:
nums = [1, 3, 5, 6]
target = 2

mid = 1 -> 3 > 2
answer = 1

mid = 0 -> 1 < 2

Loop ends.

Insert Position = 1

Key Observation:
The insertion position is exactly the Lower Bound
(first index where nums[i] >= target).

------------------------------------------------------------
*/