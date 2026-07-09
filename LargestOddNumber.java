import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Largest Odd Number in String

Approach:
1. Traverse the string from right to left.
2. Find the first odd digit.
3. The required substring is from the beginning
   up to that odd digit.
4. Remove leading zeros from this substring.
5. If no odd digit exists, return an empty string.

Time Complexity : O(n)
Space Complexity: O(n)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class LargestOddNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read input string
        String s = sc.next();

        int lastOddIndex = -1;

        // Find the last odd digit
        for (int i = s.length() - 1; i >= 0; i--) {

            int digit = s.charAt(i) - '0';

            if (digit % 2 == 1) {
                lastOddIndex = i;
                break;
            }
        }

        // No odd number exists
        if (lastOddIndex == -1) {

            System.out.println("");
            sc.close();
            return;
        }

        // Largest odd substring
        String result = s.substring(0, lastOddIndex + 1);

        // Remove leading zeros
        int start = 0;

        while (start < result.length() - 1 &&
               result.charAt(start) == '0') {

            start++;
        }

        System.out.println(result.substring(start));

        sc.close();
    }
}