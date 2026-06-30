import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Pascal's Triangle I
Platform: TUF A2Z DSA Sheet
Topic   : Arrays / Maths
Difficulty: Easy

Approach:
The value at the rth row and cth column of Pascal's Triangle
is given by the Binomial Coefficient:

                (r-1)!
Value = -------------------------
        (c-1)! * (r-c)!

Instead of calculating factorials, compute the answer
iteratively to avoid overflow.

Time Complexity : O(c)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class PascalsTriangle1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read row and column (1-based indexing)
        int r = sc.nextInt();
        int c = sc.nextInt();

        long answer = 1;

        // Compute nCr where:
        // n = r - 1
        // r = c - 1
        for (int i = 0; i < c - 1; i++) {
            answer = answer * (r - 1 - i);
            answer = answer / (i + 1);
        }

        System.out.println(answer);

        sc.close();
    }
}

/*
------------------------------------------------------------
Dry Run

Input:
r = 5
c = 3

Need:
4C2

ans = 1

i = 0
ans = 1 * 4 / 1 = 4

i = 1
ans = 4 * 3 / 2 = 6

Output:
6

Key Observation:
The element at position (r, c) is simply
the binomial coefficient (r-1)C(c-1).

------------------------------------------------------------
*/