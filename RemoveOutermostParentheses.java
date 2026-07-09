import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Remove Outermost Parentheses

Approach:
1. Traverse the string character by character.
2. Maintain a counter 'depth' representing the current
   nesting level.
3. For every '(':
      - If depth > 0, append it to the answer.
      - Then increase depth.
4. For every ')':
      - First decrease depth.
      - If depth > 0, append it to the answer.
5. This removes the outermost parentheses of every
   primitive valid parentheses string.

Time Complexity : O(n)
Space Complexity: O(n)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class RemoveOutermostParentheses {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read the parentheses string
        String s = sc.next();

        StringBuilder result = new StringBuilder();

        int depth = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {

                if (depth > 0) {
                    result.append(ch);
                }

                depth++;

            } else {

                depth--;

                if (depth > 0) {
                    result.append(ch);
                }
            }
        }

        System.out.println(result.toString());

        sc.close();
    }
}

