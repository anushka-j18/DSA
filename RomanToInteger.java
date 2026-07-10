import java.util.HashMap;
import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Roman to Integer

Approach:
1. Store the integer value of each Roman numeral
   in a HashMap.
2. Traverse the string from left to right.
3. If the current symbol has a smaller value than
   the next symbol, subtract its value.
4. Otherwise, add its value.
5. The accumulated sum is the required integer.

Time Complexity : O(n)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class RomanToInteger {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read Roman numeral
        String s = sc.next();

        HashMap<Character, Integer> romanMap = new HashMap<>();

        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0;

        for (int i = 0; i < s.length(); i++) {

            int current = romanMap.get(s.charAt(i));

            if (i < s.length() - 1) {

                int next = romanMap.get(s.charAt(i + 1));

                if (current < next) {
                    result -= current;
                } else {
                    result += current;
                }

            } else {

                result += current;
            }
        }

        System.out.println(result);

        sc.close();
    }
}