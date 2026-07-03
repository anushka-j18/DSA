import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Find Square Root of a Number

Approach:
1. Apply Binary Search on the range [1, n].
2. For every middle element:
      - If mid * mid <= n,
        store mid as a possible answer and search right.
      - Otherwise, search left.
3. The stored answer will be the floor value of √n.

Time Complexity : O(log n)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class SquareRoot {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read number
        int n = sc.nextInt();

        // Edge Cases
        if (n == 0 || n == 1) {
            System.out.println(n);
            return;
        }

        int low = 1;
        int high = n;
        int answer = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Use long to prevent integer overflow
            long square = (long) mid * mid;

            if (square == n) {
                System.out.println(mid);
                return;
            }

            if (square < n) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
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
36

low = 1
high = 36

mid = 18
18² > 36
Search left

mid = 9
9² > 36
Search left

mid = 4
4² < 36
answer = 4
Search right

mid = 6
6² = 36

Output:
6

--------------------------------------------

Input:
28

mid = 14
14² > 28

mid = 7
7² > 28

mid = 3
3² < 28
answer = 3

mid = 5
5² < 28
answer = 5

mid = 6
6² > 28

Output:
5

Key Observation:
Binary Search efficiently finds the largest integer
whose square is less than or equal to n.

------------------------------------------------------------
*/