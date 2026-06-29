import java.util.HashMap;
import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Count Subarrays with Given Sum
Platform: TUF A2Z DSA Sheet
Topic   : Arrays + Hashing
Difficulty: Medium

Approach:
1. Maintain a running prefix sum while traversing the array.
2. Store the frequency of each prefix sum in a HashMap.
3. For every element:
      - Update the current prefix sum.
      - If (prefixSum - k) exists in the map, then those many
        subarrays ending at the current index have sum = k.
4. Increase the frequency of the current prefix sum.
5. Initialize the map with (0 -> 1) to handle subarrays
   starting from index 0.

Time Complexity : O(n)
Space Complexity: O(n)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class CountSubarraysWithSumK {

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

        HashMap<Integer, Integer> prefixSumFrequency = new HashMap<>();

        // Prefix sum 0 occurs once before traversal
        prefixSumFrequency.put(0, 1);

        int prefixSum = 0;
        int subarrayCount = 0;

        // Traverse the array
        for (int num : nums) {

            prefixSum += num;

            // Check if a valid subarray exists
            if (prefixSumFrequency.containsKey(prefixSum - k)) {
                subarrayCount += prefixSumFrequency.get(prefixSum - k);
            }

            // Update frequency of current prefix sum
            prefixSumFrequency.put(prefixSum,
                    prefixSumFrequency.getOrDefault(prefixSum, 0) + 1);
        }

        System.out.println(subarrayCount);

        sc.close();
    }
}

/*
------------------------------------------------------------
Dry Run

Input:
nums = [1, 1, 1]
k = 2

Prefix Sum    Map              Count

0             {0=1}             0

1             {0=1,1=1}         0

2             {0=1,1=1,2=1}     1

3             {0=1,1=1,2=1,3=1} 2

Answer = 2

Key Observation:
If:
Current Prefix Sum = P

and

Previous Prefix Sum = P - K

Then,
Subarray Sum = K

Hence, checking (prefixSum - k) in the HashMap
immediately tells us how many valid subarrays end
at the current index.

------------------------------------------------------------
*/