import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Upper Bound

Approach:
1. Apply Binary Search on the sorted array.
2. Maintain an answer initialized to n (array size).
3. If nums[mid] > x:
      - Store mid as a possible answer.
      - Continue searching in the left half for a smaller index.
4. Otherwise, search in the right half.
5. Return the stored answer.

Time Complexity : O(log n)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class UpperBound {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read array size
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Read sorted array
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Read target value
        int x = sc.nextInt();

        int low = 0;
        int high = n - 1;
        int answer = n;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] > x) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(answer);

        sc.close();
    }
}

/*
------------------------------------------------------------
Dry Run

Input:
nums = [1, 2, 2, 3]
x = 2

low = 0
high = 3

mid = 1
nums[mid] = 2

2 <= 2
Search right

low = 2
high = 3

mid = 2
nums[mid] = 2

2 <= 2
Search right

low = 3
high = 3

mid = 3
nums[mid] = 3

3 > 2
answer = 3
Search left

Loop ends.

Output:
3

Key Observation:
Whenever nums[mid] > x,
store mid as a possible answer and continue
searching towards the left to find the first
element strictly greater than x.

------------------------------------------------------------
*/