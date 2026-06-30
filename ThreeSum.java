import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
------------------------------------------------------------
Problem : 3 Sum
Platform: TUF A2Z DSA Sheet
Topic   : Arrays + Two Pointers
Difficulty: Medium

Approach:
1. Sort the array.
2. Fix one element at a time.
3. Use two pointers (left and right) to find the remaining
   two numbers whose sum equals the negative of the fixed element.
4. Skip duplicate elements to avoid duplicate triplets.
5. Store every valid triplet.

Time Complexity : O(n²)
Space Complexity: O(1) (excluding output list)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class ThreeSum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read array size
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Read array elements
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n - 2; i++) {

            // Skip duplicate first elements
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    left++;
                    right--;

                    // Skip duplicate left elements
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    // Skip duplicate right elements
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }

                } else if (sum < 0) {

                    left++;

                } else {

                    right--;
                }
            }
        }

        System.out.println(result);

        sc.close();
    }
}

/*
------------------------------------------------------------
Dry Run

Input:
[2, -2, 0, 3, -3, 5]

After Sorting:
[-3, -2, 0, 2, 3, 5]

i = -3
left = -2
right = 5

Sum = 0
Triplet = [-3, -2, 5]

Move pointers

Next:
left = 0
right = 3

Sum = 0
Triplet = [-3, 0, 3]

Next

i = -2

left = 0
right = 2

Sum = 0
Triplet = [-2, 0, 2]

Output:
[[-3, -2, 5], [-3, 0, 3], [-2, 0, 2]]

Key Observation:
Sorting allows us to efficiently use two pointers
instead of checking every possible triplet.

------------------------------------------------------------
*/