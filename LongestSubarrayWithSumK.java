import java.util.HashMap;
import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Longest Subarray with Sum K
Platform: TUF A2Z DSA Sheet
Topic   : Arrays + Hashing
Difficulty: Medium

Approach:
1. Maintain a running prefix sum while traversing the array.
2. Store the first occurrence of every prefix sum in a HashMap.
3. If the current prefix sum equals k, then the subarray from
   index 0 to the current index has sum k.
4. If (prefixSum - k) exists in the HashMap, then a subarray
   with sum k exists. Update the maximum length.
5. Store only the first occurrence of a prefix sum because it
   gives the longest possible subarray.

Time Complexity : O(n)
Space Complexity: O(n)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class LongestSubarrayWithSumK {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read array size
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Read array elements
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Read target sum
        int k = sc.nextInt();

        HashMap<Integer, Integer> prefixMap = new HashMap<>();

        int prefixSum = 0;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {

            // Update prefix sum
            prefixSum += nums[i];

            // Case 1: Subarray starts from index 0
            if (prefixSum == k) {
                maxLength = i + 1;
            }

            // Case 2: Subarray starts after index 0
            if (prefixMap.containsKey(prefixSum - k)) {
                int length = i - prefixMap.get(prefixSum - k);
                maxLength = Math.max(maxLength, length);
            }

            // Store only the first occurrence of each prefix sum
            prefixMap.putIfAbsent(prefixSum, i);
        }

        System.out.println(maxLength);

        sc.close();
    }
}