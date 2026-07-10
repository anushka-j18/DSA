import java.util.Scanner;

/*
------------------------------------------------------------
Problem : String to Integer (atoi)

Approach:
1. Skip all leading whitespaces.
2. Check for an optional '+' or '-' sign.
3. Read consecutive digits and build the number.
4. Stop when a non-digit character is encountered.
5. Check for integer overflow while building the number.
6. Return the final signed integer.

Time Complexity : O(n)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class StringToInteger {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read the complete input line
        String s = sc.nextLine();

        int index = 0;
        int sign = 1;
        long number = 0;

        // Skip leading whitespaces
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }

        // Check for sign
        if (index < s.length()) {

            if (s.charAt(index) == '-') {
                sign = -1;
                index++;
            } else if (s.charAt(index) == '+') {
                index++;
            }
        }

        // Read digits
        while (index < s.length() &&
               Character.isDigit(s.charAt(index))) {

            int digit = s.charAt(index) - '0';

            number = number * 10 + digit;

            // Handle overflow
            if (sign == 1 && number > Integer.MAX_VALUE) {
                System.out.println(Integer.MAX_VALUE);
                return;
            }

            if (sign == -1 && -number < Integer.MIN_VALUE) {
                System.out.println(Integer.MIN_VALUE);
                return;
            }

            index++;
        }

        System.out.println((int) (sign * number));

        sc.close();
    }
}