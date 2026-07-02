import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Count Occurrences in Sorted Array

Approach:
1. Use Binary Search to find the first occurrence of the target.
2. Use another Binary Search to find the last occurrence.
3. If the target is not found, return 0.
4. Otherwise, count = lastOccurrence - firstOccurrence + 1.

Time Complexity : O(log n)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class CountOccurrences {

    // Find first occurrence
    static int firstOccurrence(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;
        int first = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                first = mid;
                high = mid - 1;
            } 
            else if (arr[mid] < target) {
                low = mid + 1;
            } 
            else {
                high = mid - 1;
            }
        }

        return first;
    }

    // Find last occurrence
    static int lastOccurrence(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;
        int last = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                last = mid;
                low = mid + 1;
            } 
            else if (arr[mid] < target) {
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

        int[] arr = new int[n];

        // Read sorted array
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Read target
        int target = sc.nextInt();

        int first = firstOccurrence(arr, target);

        // Target not found
        if (first == -1) {
            System.out.println(0);
        } else {
            int last = lastOccurrence(arr, target);
            System.out.println(last - first + 1);
        }

        sc.close();
    }
}

/*
------------------------------------------------------------
Dry Run

Input:
arr = [0, 0, 1, 1, 1, 2, 3]
target = 1

First Occurrence = 2
Last Occurrence = 4

Count = 4 - 2 + 1
      = 3

Output:
3

--------------------------------------------

Input:
arr = [5, 5, 5, 5, 5, 5]
target = 5

First = 0
Last = 5

Count = 5 - 0 + 1 = 6

Output:
6

Key Observation:
The number of occurrences is simply:
Last Occurrence - First Occurrence + 1

------------------------------------------------------------
*/