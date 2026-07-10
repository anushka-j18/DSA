import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Valid Anagram

Approach:
1. If the lengths of both strings are different,
   they cannot be anagrams.
2. Create a frequency array of size 26 for lowercase letters.
3. Traverse both strings simultaneously:
      - Increment the count for characters in s.
      - Decrement the count for characters in t.
4. After traversal, if every frequency is zero,
   the strings are anagrams.
5. Otherwise, they are not.

Time Complexity : O(n)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class ValidAnagram {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read both strings
        String s = sc.next();
        String t = sc.next();

        // Lengths must be equal
        if (s.length() != t.length()) {

            System.out.println(false);
            return;
        }

        int[] frequency = new int[26];

        // Count character frequencies
        for (int i = 0; i < s.length(); i++) {

            frequency[s.charAt(i) - 'a']++;
            frequency[t.charAt(i) - 'a']--;
        }

        // Verify all frequencies are zero
        for (int count : frequency) {

            if (count != 0) {

                System.out.println(false);
                return;
            }
        }

        System.out.println(true);

        sc.close();
    }
}