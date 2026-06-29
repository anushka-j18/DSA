import java.util.Arrays;
import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Rearrange Array Elements by Sign
Platform: TUF A2Z DSA Sheet
Topic   : Arrays
Difficulty: Medium

Approach:
1. Create a new array of the same size.
2. Maintain two pointers:
      - positiveIndex = 0
      - negativeIndex = 1
3. Traverse the original array.
4. If the current element is positive, place it at positiveIndex
   and move positiveIndex by 2.
5. If the current element is negative, place it at negativeIndex
   and move negativeIndex by 2.
6. This preserves the relative order of positive and negative
   numbers while ensuring alternating signs.

Time Complexity : O(n)
Space Complexity: O(n)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class RearrangeBySign {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read array size
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Read array elements
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] answer = new int[n];

        int positiveIndex = 0;
        int negativeIndex = 1;

        // Rearrange positive and negative numbers
        for (int num : nums) {

            if (num > 0) {
                answer[positiveIndex] = num;
                positiveIndex += 2;
            } else {
                answer[negativeIndex] = num;
                negativeIndex += 2;
            }
        }

        System.out.println(Arrays.toString(answer));

        sc.close();
    }
}

/*
------------------------------------------------------------
Dry Run

Input:
[2, 4, 5, -1, -3, -4]

Positive Index = 0
Negative Index = 1

2   -> [2, _, _, _, _, _]
4   -> [2, _, 4, _, _, _]
5   -> [2, _, 4, _, 5, _]
-1  -> [2, -1, 4, _, 5, _]
-3  -> [2, -1, 4, -3, 5, _]
-4  -> [2, -1, 4, -3, 5, -4]

Output:
[2, -1, 4, -3, 5, -4]

Key Observation:
Even indices store positive numbers.
Odd indices store negative numbers.
Since each pointer moves by 2, the original order of positive
and negative numbers is preserved.

------------------------------------------------------------
*/