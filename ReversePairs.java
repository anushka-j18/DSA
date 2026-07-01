import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Reverse Pairs
Platform: TUF A2Z DSA Sheet
Topic   : Arrays + Merge Sort
Difficulty: Hard

Approach:
1. Use Merge Sort to divide the array into two halves.
2. Before merging, count reverse pairs:
      nums[i] > 2 * nums[j]
   where i belongs to the left half and j belongs to the right half.
3. Since both halves are sorted, use two pointers to count
   reverse pairs efficiently.
4. Merge the two sorted halves.
5. Sum up the counts from:
      - Left half
      - Right half
      - Cross pairs

Time Complexity : O(n log n)
Space Complexity: O(n)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class ReversePairs {

    // Count reverse pairs between two sorted halves
    static int countPairs(int[] nums, int low, int mid, int high) {

        int count = 0;
        int right = mid + 1;

        for (int left = low; left <= mid; left++) {

            while (right <= high &&
                    (long) nums[left] > 2L * nums[right]) {
                right++;
            }

            count += (right - (mid + 1));
        }

        return count;
    }

    // Merge two sorted halves
    static void merge(int[] nums, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];

        int left = low;
        int right = mid + 1;
        int index = 0;

        while (left <= mid && right <= high) {

            if (nums[left] <= nums[right]) {
                temp[index++] = nums[left++];
            } else {
                temp[index++] = nums[right++];
            }
        }

        while (left <= mid) {
            temp[index++] = nums[left++];
        }

        while (right <= high) {
            temp[index++] = nums[right++];
        }

        for (int i = 0; i < temp.length; i++) {
            nums[low + i] = temp[i];
        }
    }

    // Merge Sort
    static int mergeSort(int[] nums, int low, int high) {

        if (low >= high)
            return 0;

        int mid = low + (high - low) / 2;

        int count = 0;

        count += mergeSort(nums, low, mid);

        count += mergeSort(nums, mid + 1, high);

        count += countPairs(nums, low, mid, high);

        merge(nums, low, mid, high);

        return count;
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

        int reversePairs = mergeSort(nums, 0, n - 1);

        System.out.println(reversePairs);

        sc.close();
    }
}

/*
------------------------------------------------------------
Dry Run

Input:
[6, 4, 1, 2, 7]

Divide:

[6,4,1]     [2,7]

After sorting:

[1,4,6]     [2,7]

Count reverse pairs:

6 > 2*2 ✓
6 > 2*1 ✓
4 > 2*1 ✓

Total = 3

Output:
3

Key Observation:
Since both halves are sorted, the right pointer never
moves backward. This allows counting reverse pairs
in linear time during each merge step.

------------------------------------------------------------
*/