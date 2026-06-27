import java.util.Arrays;
import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Sort an Array of 0's, 1's and 2's
Platform: TUF A2Z DSA Sheet
Topic   : Arrays
Difficulty: Medium

Approach (Dutch National Flag Algorithm):
1. Maintain three pointers:
      low  -> next position for 0
      mid  -> current element
      high -> next position for 2
2. Traverse the array until mid <= high.
3. If nums[mid] == 0:
      - Swap nums[low] and nums[mid]
      - Increment both low and mid.
4. If nums[mid] == 1:
      - Element is already in correct position.
      - Increment mid.
5. If nums[mid] == 2:
      - Swap nums[mid] and nums[high]
      - Decrement high only.

Time Complexity : O(n)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class Sort012 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read array size
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Read array elements
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int low = 0;
        int mid = 0;
        int high = n - 1;

        while (mid <= high) {

            if (nums[mid] == 0) {

                // Place 0 at the beginning
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;

                low++;
                mid++;

            } else if (nums[mid] == 1) {

                // 1 is already in correct region
                mid++;

            } else {

                // Place 2 at the end
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;

                high--;
            }
        }

        System.out.println(Arrays.toString(nums));

        sc.close();
    }
}