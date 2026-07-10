import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Longest Palindromic Substring

Approach:
1. Every character can be the center of a palindrome.
2. Expand around each possible center:
      - Odd length palindrome (single center).
      - Even length palindrome (two centers).
3. While the characters on both sides are equal,
   expand outward.
4. Track the starting index and maximum length of
   the longest palindrome found.
5. Return the longest palindromic substring.

Time Complexity : O(n²)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class LongestPalindromicSubstring {

    // Expand around the given center
    static int expand(String s, int left, int right) {

        while (left >= 0 &&
               right < s.length() &&
               s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }

        return right - left - 1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read input string
        String s = sc.next();

        if (s.length() == 0) {
            System.out.println("");
            return;
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {

            // Odd length palindrome
            int len1 = expand(s, i, i);

            // Even length palindrome
            int len2 = expand(s, i, i + 1);

            int maxLength = Math.max(len1, len2);

            if (maxLength > end - start + 1) {

                start = i - (maxLength - 1) / 2;
                end = i + maxLength / 2;
            }
        }

        System.out.println(s.substring(start, end + 1));

        sc.close();
    }
}