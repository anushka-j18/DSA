import java.util.Arrays;
import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Find the Repeating and Missing Number
Platform: TUF A2Z DSA Sheet
Topic   : Arrays + Mathematics
Difficulty: Medium

Approach (Mathematical Method):

Let:
x = Repeating Number
y = Missing Number

Expected Sum = n(n+1)/2
Actual Sum = Sum of array

Equation 1:
x - y = ActualSum - ExpectedSum

Expected Square Sum = n(n+1)(2n+1)/6
Actual Square Sum = Sum of squares of array

Equation 2:
x² - y² = ActualSquareSum - ExpectedSquareSum

Since,
x² - y² = (x-y)(x+y)

We obtain:
x + y

Using:
x - y
x + y

we can calculate:
x (repeating)
y (missing)

Time Complexity : O(n)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class FindMissingAndRepeating {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read array size
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Read array elements
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        long expectedSum = (long) n * (n + 1) / 2;
        long expectedSquareSum = (long) n * (n + 1) * (2L * n + 1) / 6;

        long actualSum = 0;
        long actualSquareSum = 0;

        // Calculate actual sums
        for (int num : nums) {
            actualSum += num;
            actualSquareSum += (long) num * num;
        }

        long diff = actualSum - expectedSum; // x - y

        long squareDiff = actualSquareSum - expectedSquareSum; // x² - y²

        long sum = squareDiff / diff; // x + y

        int repeating = (int) ((diff + sum) / 2);

        int missing = (int) (sum - repeating);

        System.out.println(Arrays.toString(new int[]{repeating, missing}));

        sc.close();
    }
}

/*
------------------------------------------------------------
Dry Run

Input:
[3, 5, 4, 1, 1]

Expected Sum = 15
Actual Sum = 14

x - y = -1

Expected Square Sum = 55
Actual Square Sum = 52

x² - y² = -3

x + y = (-3)/(-1) = 3

Now,

x = ((x-y)+(x+y))/2
  = (-1+3)/2 = 1

y = 3 - 1 = 2

Output:
[1, 2]

Key Observation:
Instead of using extra arrays or modifying the input,
two mathematical equations are enough to determine the
repeating and missing numbers.

------------------------------------------------------------
*/