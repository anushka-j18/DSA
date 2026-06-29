import java.util.Arrays;
import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Next Permutation
Platform: TUF A2Z DSA Sheet
Topic   : Arrays
Difficulty: Medium

Approach:
1. Traverse from right to left and find the first index 'i'
   such that nums[i] < nums[i + 1]. This is the breakpoint.
2. If no breakpoint exists, the array is the last permutation.
   Reverse the entire array to obtain the first permutation.
3. Otherwise, traverse from the end and find the first element
   greater than nums[i].
4. Swap that element with nums[i].
5. Reverse the part of the array after index i.
   This produces the next lexicographically greater permutation.

Time Complexity : O(n)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class NextPermutation {

    // Reverse elements from start to end
    static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
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

        // Step 1: Find the breakpoint
        int index = -1;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        // Step 2: If no breakpoint, reverse the whole array
        if (index == -1) {
            reverse(nums, 0, n - 1);
        } else {

            // Step 3: Find the next greater element
            for (int i = n - 1; i > index; i--) {
                if (nums[i] > nums[index]) {

                    // Step 4: Swap
                    int temp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = temp;
                    break;
                }
            }

            // Step 5: Reverse the suffix
            reverse(nums, index + 1, n - 1);
        }

        System.out.println(Arrays.toString(nums));

        sc.close();
    }
}

/*
------------------------------------------------------------
Dry Run

Input:
[1, 2, 3]

Breakpoint:
2 < 3
index = 1

Swap:
[1, 3, 2]

Reverse suffix:
Only one element remains.

Output:
[1, 3, 2]

--------------------------------------------

Input:
[3, 2, 1]

No breakpoint found.

Reverse entire array.

Output:
[1, 2, 3]

Key Observation:
The suffix after the breakpoint is always in descending order.
Reversing it after swapping produces the smallest possible
lexicographically greater permutation.

------------------------------------------------------------
*/