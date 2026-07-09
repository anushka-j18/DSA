import java.util.HashMap;
import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Isomorphic Strings

Approach:
1. If the lengths of both strings are different,
   they cannot be isomorphic.
2. Use two HashMaps:
      - First map stores mapping from s -> t.
      - Second map stores mapping from t -> s.
3. Traverse both strings together.
4. For every pair of characters:
      - If a mapping already exists, verify it.
      - Otherwise, create a new mapping.
5. If any mapping is inconsistent, return false.
6. If the traversal completes successfully,
   return true.

Time Complexity : O(n)
Space Complexity: O(1)
(At most 256 character mappings)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class IsomorphicStrings {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read both strings
        String s = sc.next();
        String t = sc.next();

        if (s.length() != t.length()) {
            System.out.println(false);
            return;
        }

        HashMap<Character, Character> mapST = new HashMap<>();
        HashMap<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char chS = s.charAt(i);
            char chT = t.charAt(i);

            if (mapST.containsKey(chS)) {

                if (mapST.get(chS) != chT) {
                    System.out.println(false);
                    return;
                }

            } else {

                mapST.put(chS, chT);
            }

            if (mapTS.containsKey(chT)) {

                if (mapTS.get(chT) != chS) {
                    System.out.println(false);
                    return;
                }

            } else {

                mapTS.put(chT, chS);
            }
        }

        System.out.println(true);

        sc.close();
    }
}