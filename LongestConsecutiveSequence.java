import java.util.HashSet;
import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Longest Consecutive Sequence in an Array
Platform: TUF A2Z DSA Sheet
Topic   : Arrays + Hashing
Difficulty: Medium

Approach:
1. Store all array elements in a HashSet.
2. Traverse each element in the set.
3. If (currentElement - 1) is not present, then the current
   element is the start of a consecutive sequence.
4. Count the length of the sequence by checking
   currentElement + 1, currentElement + 2, ...
5. Keep updating the maximum sequence length.

Time Complexity : O(n)
Space Complexity: O(n)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class LongestConsecutiveSequence {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read array size
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Read array elements
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        HashSet<Integer> set = new HashSet<>();

        // Store all elements in the HashSet
        for (int num : nums) {
            set.add(num);
        }

        int longestLength = 0;

        // Find the longest consecutive sequence
        for (int num : set) {

            // Check if the current element is the start of a sequence
            if (!set.contains(num - 1)) {

                int currentNumber = num;
                int currentLength = 1;

                // Count consecutive elements
                while (set.contains(currentNumber + 1)) {
                    currentNumber++;
                    currentLength++;
                }

                longestLength = Math.max(longestLength, currentLength);
            }
        }

        System.out.println(longestLength);

        sc.close();
    }
}

/*
------------------------------------------------------------
Dry Run

Input:
[100, 4, 200, 1, 3, 2]

HashSet:
{100, 4, 200, 1, 3, 2}

100 -> Start of sequence
Length = 1

4 -> Not start (3 exists)

200 -> Start of sequence
Length = 1

1 -> Start of sequence
1 -> 2 -> 3 -> 4
Length = 4

Answer = 4

Key Observation:
Only begin counting from numbers that do not have a
predecessor (num - 1). This ensures each sequence is
counted exactly once.

------------------------------------------------------------
*/