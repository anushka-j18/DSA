import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Count Inversions
Platform: TUF A2Z DSA Sheet
Topic   : Arrays + Merge Sort
Difficulty: Hard

Approach:
1. Use Merge Sort to divide the array into smaller halves.
2. Count inversions in:
      - Left half
      - Right half
      - During the merge step
3. While merging:
      - If left element <= right element, copy left element.
      - Otherwise, every remaining element in the left half
        forms an inversion with the current right element.
      - Count += (mid - leftIndex + 1)

Time Complexity : O(n log n)
Space Complexity: O(n)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class CountInversions {

    // Merge two sorted halves and count inversions
    static long merge(int[] nums, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];

        int left = low;
        int right = mid + 1;
        int index = 0;

        long inversions = 0;

        while (left <= mid && right <= high) {

            if (nums[left] <= nums[right]) {

                temp[index++] = nums[left++];

            } else {

                temp[index++] = nums[right++];

                // Remaining elements in left half form inversions
                inversions += (mid - left + 1);
            }
        }

        while (left <= mid) {
            temp[index++] = nums[left++];
        }

        while (right <= high) {
            temp[index++] = nums[right++];
        }

        // Copy merged elements back
        for (int i = 0; i < temp.length; i++) {
            nums[low + i] = temp[i];
        }

        return inversions;
    }

    // Merge Sort
    static long mergeSort(int[] nums, int low, int high) {

        if (low >= high)
            return 0;

        int mid = low + (high - low) / 2;

        long inversions = 0;

        inversions += mergeSort(nums, low, mid);

        inversions += mergeSort(nums, mid + 1, high);

        inversions += merge(nums, low, mid, high);

        return inversions;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read array size
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Read array elements
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        long inversionCount = mergeSort(nums, 0, n - 1);

        System.out.println(inversionCount);

        sc.close();
    }
}

/*
------------------------------------------------------------
Dry Run

Input:
[2, 3, 7, 1, 3, 5]

Merge Step:

Left:
[2,3,7]

Right:
[1,3,5]

When comparing:

2 > 1
Remaining in left = 3
Count += 3

7 > 3
Remaining in left = 1
Count += 1

7 > 5
Remaining in left = 1
Count += 1

Total = 5

Output:
5

Key Observation:
Whenever an element from the right half is placed before
elements remaining in the left half, all those remaining
left elements form inversions.

------------------------------------------------------------
*/