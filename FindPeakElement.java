import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Find Peak Element

Approach:
1. Handle edge cases:
      - If the array has only one element.
      - If the first element is greater than the second.
      - If the last element is greater than the second last.
2. Apply Binary Search on the remaining elements.
3. If nums[mid] is greater than both its neighbours,
   then it is a peak.
4. If the left neighbour is greater than nums[mid],
   then a peak must exist on the left.
5. Otherwise, search on the right half.

Time Complexity : O(log n)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class FindPeakElement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read array size
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Read array elements
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Edge Case: Only one element
        if (n == 1) {
            System.out.println(0);
            return;
        }

        // Edge Case: First element is peak
        if (arr[0] > arr[1]) {
            System.out.println(0);
            return;
        }

        // Edge Case: Last element is peak
        if (arr[n - 1] > arr[n - 2]) {
            System.out.println(n - 1);
            return;
        }

        int low = 1;
        int high = n - 2;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Peak found
            if (arr[mid] > arr[mid - 1] &&
                arr[mid] > arr[mid + 1]) {

                System.out.println(mid);
                return;
            }

            // Peak lies on the left side
            if (arr[mid - 1] > arr[mid]) {
                high = mid - 1;
            }

            // Peak lies on the right side
            else {
                low = mid + 1;
            }
        }

        sc.close();
    }
}

/*
------------------------------------------------------------
Dry Run

Input:
arr = [1,2,3,4,5,6,7,8,5,1]

low = 1
high = 8

mid = 4
arr[mid] = 5

Right neighbour is greater.
Search right half.

low = 5
high = 8

mid = 6
arr[mid] = 7

Right neighbour is greater.
Search right half.

low = 7
high = 8

mid = 7
arr[mid] = 8

8 > 7
8 > 5

Peak found at index 7.

Output:
7

Key Observation:
If arr[mid] < arr[mid + 1],
a peak definitely exists on the right.

If arr[mid] < arr[mid - 1],
a peak definitely exists on the left.

This property allows Binary Search.

------------------------------------------------------------
*/