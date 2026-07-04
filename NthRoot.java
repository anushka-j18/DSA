import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Find Nth Root of a Number

Approach:
1. Apply Binary Search on the range [1, M].
2. For every middle value, calculate mid^N.
3. If mid^N == M, return mid.
4. If mid^N < M, search in the right half.
5. Otherwise, search in the left half.
6. If no integer root exists, return -1.

Time Complexity : O(N × log M)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class NthRoot {

    // Function to compare mid^n with m
    static int power(int mid, int n, int m) {

        long result = 1;

        for (int i = 1; i <= n; i++) {

            result *= mid;

            // Prevent overflow and unnecessary computation
            if (result > m) {
                return 2;
            }
        }

        if (result == m) {
            return 1;
        }

        return 0;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read N and M
        int n = sc.nextInt();
        int m = sc.nextInt();

        int low = 1;
        int high = m;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int value = power(mid, n, m);

            if (value == 1) {
                System.out.println(mid);
                return;
            }
            else if (value == 0) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        System.out.println(-1);

        sc.close();
    }
}

/*
------------------------------------------------------------
Dry Run

Input:
N = 3
M = 27

low = 1
high = 27

mid = 14

14³ > 27
Search left

mid = 7

7³ > 27
Search left

mid = 3

3³ = 27

Output:
3

--------------------------------------------

Input:
N = 4
M = 69

No integer x satisfies:

x⁴ = 69

Output:
-1

Key Observation:
Instead of calculating decimal roots,
Binary Search finds the integer whose Nth power
matches M exactly.

------------------------------------------------------------
*/