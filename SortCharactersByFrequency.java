import java.util.*;

/*
------------------------------------------------------------
Problem : Sort Characters by Frequency

Approach:
1. Count the frequency of each character using a HashMap.
2. Store all unique characters in a list.
3. Sort the list based on:
      - Higher frequency first.
      - If frequencies are equal, smaller alphabet first.
4. Print the sorted list of unique characters.

Time Complexity : O(n + k log k)
where:
n = length of string
k = number of unique characters

Space Complexity: O(k)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class SortCharactersByFrequency {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read input string
        String s = sc.next();

        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        // Count frequencies
        for (char ch : s.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        // Store unique characters
        List<Character> characters = new ArrayList<>(frequencyMap.keySet());

        // Sort by frequency (descending), then alphabetically
        Collections.sort(characters, (a, b) -> {

            if (!frequencyMap.get(a).equals(frequencyMap.get(b))) {
                return frequencyMap.get(b) - frequencyMap.get(a);
            }

            return Character.compare(a, b);
        });

        System.out.println(characters);

        sc.close();
    }
}