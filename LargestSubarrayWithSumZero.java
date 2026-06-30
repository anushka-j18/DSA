import java.util.HashMap;
import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Largest Subarray with Sum 0
Platform: TUF A2Z DSA Sheet
Topic   : Arrays + Hashing
Difficulty: Medium

Approach:
1. Maintain a running prefix sum while traversing the array.
2. If the prefix sum becomes 0, then the subarray from
   index 0 to the current index has sum 0.
3. Store the first occurrence of every prefix sum in a HashMap.
4. If the same prefix sum appears again, then the subarray
   between the two indices has sum 0.
5. Update the maximum length whenever such a subarray is found.

Time Complexity : O(n)
Space Complexity: O(n)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class LargestSubarrayWithSumZero {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read array size
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Read array elements
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> prefixMap = new HashMap<>();

        int prefixSum = 0;
        int maxLength = 0;

        // Traverse the array
        for (int i = 0; i < n; i++) {

            // Update prefix sum
            prefixSum += arr[i];

            // If prefix sum is zero, subarray starts from index 0
            if (prefixSum == 0) {
                maxLength = i + 1;
            }

            // If prefix sum has appeared before
            if (prefixMap.containsKey(prefixSum)) {

                int length = i - prefixMap.get(prefixSum);
                maxLength = Math.max(maxLength, length);

            } else {

                // Store first occurrence of prefix sum
                prefixMap.put(prefixSum, i);
            }
        }

        System.out.println(maxLength);

        sc.close();
    }
}

/*
------------------------------------------------------------
Dry Run

Input:
[15, -2, 2, -8, 1, 7, 10, 23]

Prefix Sum:

15
13
15
7
8
15
25
48

Prefix sum 15 appears at:
Index 0
Index 2
Index 5

Subarray:
[-2, 2, -8, 1, 7]

Length = 5

Answer = 5

Key Observation:
If the same prefix sum occurs at two different indices,
then the elements between those indices sum to zero.

------------------------------------------------------------
*/