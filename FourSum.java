import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
------------------------------------------------------------
Problem : 4 Sum
Platform: TUF A2Z DSA Sheet
Topic   : Arrays + Two Pointers
Difficulty: Medium

Approach:
1. Sort the array.
2. Fix the first two elements using nested loops.
3. Use two pointers (left and right) to find the
   remaining two elements.
4. Skip duplicate values to avoid duplicate quadruplets.
5. Use long while calculating the sum to avoid integer overflow.

Time Complexity : O(n³)
Space Complexity: O(1) (excluding output list)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class FourSum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read array size
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Read array elements
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Read target
        int target = sc.nextInt();

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n - 3; i++) {

            // Skip duplicate first elements
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < n - 2; j++) {

                // Skip duplicate second elements
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = n - 1;

                while (left < right) {

                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {

                        result.add(Arrays.asList(
                                nums[i],
                                nums[j],
                                nums[left],
                                nums[right]
                        ));

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

                    } else if (sum < target) {

                        left++;

                    } else {

                        right--;
                    }
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
nums = [1, -2, 3, 5, 7, 9]
target = 7

After Sorting:
[-2, 1, 3, 5, 7, 9]

i = -2
j = 1

left = 3
right = 9

Sum = 11 > 7
Move right

left = 3
right = 7

Sum = 9 > 7
Move right

left = 3
right = 5

Sum = 7

Quadruplet:
[-2, 1, 3, 5]

Output:
[[-2, 1, 3, 5]]

Key Observation:
Sorting enables the use of the Two Pointer technique,
reducing the complexity from O(n⁴) to O(n³).

------------------------------------------------------------
*/