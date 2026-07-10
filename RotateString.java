import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Rotate String

Approach:
1. If the lengths of both strings are different,
   rotation is impossible.
2. Concatenate the original string with itself.
3. If the goal string is a substring of the
   concatenated string, then it is a valid rotation.
4. Otherwise, return false.

Example:
s = "abcde"

s + s = "abcdeabcde"

goal = "cdeab"

Since "cdeab" exists in "abcdeabcde",
the answer is true.

Time Complexity : O(n)
Space Complexity: O(n)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class RotateString {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read both strings
        String s = sc.next();
        String goal = sc.next();

        // Lengths must be equal
        if (s.length() != goal.length()) {

            System.out.println(false);
            return;
        }

        // Concatenate the string with itself
        String doubled = s + s;

        // Check if goal is a substring
        System.out.println(doubled.contains(goal));

        sc.close();
    }
}