import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Sum of Beauty of All Substrings

Approach:
1. Consider every index as the starting point of a substring.
2. Maintain a frequency array of size 26.
3. Extend the substring one character at a time.
4. After adding a character:
      - Update its frequency.
      - Find:
            • Maximum frequency
            • Minimum non-zero frequency
      - Beauty = Maximum - Minimum.
5. Add the beauty of every substring to the final answer.

Time Complexity : O(26 × n²)
Space Complexity: O(26) = O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class SumOfBeautyOfAllSubstrings {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read input string
        String s = sc.next();

        int n = s.length();
        int totalBeauty = 0;

        // Consider every starting index
        for (int i = 0; i < n; i++) {

            int[] frequency = new int[26];

            // Extend substring
            for (int j = i; j < n; j++) {

                frequency[s.charAt(j) - 'a']++;

                int maximum = 0;
                int minimum = Integer.MAX_VALUE;

                // Find maximum and minimum non-zero frequency
                for (int count : frequency) {

                    if (count > 0) {

                        maximum = Math.max(maximum, count);
                        minimum = Math.min(minimum, count);
                    }
                }

                totalBeauty += (maximum - minimum);
            }
        }

        System.out.println(totalBeauty);

        sc.close();
    }
}