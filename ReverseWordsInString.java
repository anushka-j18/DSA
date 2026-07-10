import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Reverse Words in a String

Approach:
1. Remove leading and trailing spaces.
2. Split the string using one or more spaces.
3. Traverse the words array from the end to the beginning.
4. Append each word to the result with a single space.
5. Print the final reversed string.

Time Complexity : O(n)
Space Complexity: O(n)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class ReverseWordsInString {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read the complete input line
        String s = sc.nextLine();

        // Remove leading and trailing spaces
        s = s.trim();

        // Split using one or more spaces
        String[] words = s.split("\\s+");

        StringBuilder result = new StringBuilder();

        // Append words in reverse order
        for (int i = words.length - 1; i >= 0; i--) {

            result.append(words[i]);

            if (i != 0) {
                result.append(" ");
            }
        }

        System.out.println(result.toString());

        sc.close();
    }
}