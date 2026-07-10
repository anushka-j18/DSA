import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Maximum Nesting Depth of Parentheses

Approach:
1. Traverse the string character by character.
2. Maintain a variable 'currentDepth' to track the
   number of currently open parentheses.
3. Whenever '(' is encountered:
      - Increment currentDepth.
      - Update maximumDepth if needed.
4. Whenever ')' is encountered:
      - Decrement currentDepth.
5. Ignore all other characters.
6. The maximum value of currentDepth during traversal
   is the maximum nesting depth.

Time Complexity : O(n)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class MaximumNestingDepth {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read the complete expression
        String s = sc.nextLine();

        int currentDepth = 0;
        int maximumDepth = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {

                currentDepth++;
                maximumDepth = Math.max(maximumDepth, currentDepth);

            } else if (ch == ')') {

                currentDepth--;
            }
        }

        System.out.println(maximumDepth);

        sc.close();
    }
}