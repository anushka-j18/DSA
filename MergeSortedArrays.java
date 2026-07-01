import java.util.Arrays;
import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Merge Sorted Arrays
Platform: TUF A2Z DSA Sheet
Topic   : Arrays
Difficulty: Medium

Approach (Gap Method):
1. Treat both arrays as a single combined array.
2. Initialize the gap as ceil((m + n) / 2).
3. Compare elements that are 'gap' distance apart.
4. Swap them if they are out of order.
5. Reduce the gap until it becomes 0.
6. This merges both arrays in-place without using extra space.

Time Complexity : O((m + n) log(m + n))
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class MergeSortedArrays {

    // Function to swap elements
    static void swap(int[] arr1, int i, int[] arr2, int j) {
        int temp = arr1[i];
        arr1[i] = arr2[j];
        arr2[j] = temp;
    }

    // Function to calculate next gap
    static int nextGap(int gap) {
        if (gap <= 1)
            return 0;
        return (gap / 2) + (gap % 2);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read sizes of arrays
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[] nums1 = new int[m];
        int[] nums2 = new int[n];

        // Read first array
        for (int i = 0; i < m; i++) {
            nums1[i] = sc.nextInt();
        }

        // Read second array
        for (int i = 0; i < n; i++) {
            nums2[i] = sc.nextInt();
        }

        int len = m + n;
        int gap = nextGap(len);

        while (gap > 0) {

            int left = 0;
            int right = left + gap;

            while (right < len) {

                // Both pointers in nums1
                if (left < m && right < m) {

                    if (nums1[left] > nums1[right]) {
                        swap(nums1, left, nums1, right);
                    }

                }
                // Left in nums1, Right in nums2
                else if (left < m && right >= m) {

                    if (nums1[left] > nums2[right - m]) {
                        swap(nums1, left, nums2, right - m);
                    }

                }
                // Both pointers in nums2
                else {

                    if (nums2[left - m] > nums2[right - m]) {
                        swap(nums2, left - m, nums2, right - m);
                    }
                }

                left++;
                right++;
            }

            gap = nextGap(gap);
        }

        // Print merged array
        int[] merged = new int[m + n];

        for (int i = 0; i < m; i++)
            merged[i] = nums1[i];

        for (int i = 0; i < n; i++)
            merged[m + i] = nums2[i];

        System.out.println(Arrays.toString(merged));

        sc.close();
    }
}

/*
------------------------------------------------------------
Dry Run

Input:
nums1 = [-5, -2, 4, 5]
nums2 = [-3, 1, 8]

Gap = 4

Compare elements 4 apart.
Swap where necessary.

Gap = 2

Compare again.

Gap = 1

Final Arrays:

nums1 = [-5, -3, -2, 1]
nums2 = [4, 5, 8]

Merged Output:
[-5, -3, -2, 1, 4, 5, 8]

Key Observation:
Instead of using an extra array,
the Gap Method compares distant elements
and gradually reduces the gap,
similar to Shell Sort.

------------------------------------------------------------
*/