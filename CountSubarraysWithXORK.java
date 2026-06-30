import java.util.HashMap;
import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Count Subarrays with Given XOR K
Platform: TUF A2Z DSA Sheet
Topic   : Arrays + Hashing
Difficulty: Medium

Approach:
1. Maintain a running prefix XOR while traversing the array.
2. Store the frequency of each prefix XOR in a HashMap.
3. For every element:
      - Update the current prefix XOR.
      - If (prefixXOR ^ k) exists in the map, then those many
        subarrays ending at the current index have XOR = k.
4. Increase the frequency of the current prefix XOR.
5. Initialize the map with (0 -> 1) to handle subarrays
   starting from index 0.

Time Complexity : O(n)
Space Complexity: O(n)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class CountSubarraysWithXORK {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read array size
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Read array elements
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Read target XOR
        int k = sc.nextInt();

        HashMap<Integer, Integer> xorFrequency = new HashMap<>();

        // Prefix XOR 0 occurs once before traversal
        xorFrequency.put(0, 1);

        int prefixXOR = 0;
        int subarrayCount = 0;

        // Traverse the array
        for (int num : nums) {

            // Update prefix XOR
            prefixXOR ^= num;

            // Check if a valid subarray exists
            int requiredXOR = prefixXOR ^ k;

            if (xorFrequency.containsKey(requiredXOR)) {
                subarrayCount += xorFrequency.get(requiredXOR);
            }

            // Update frequency of current prefix XOR
            xorFrequency.put(prefixXOR,
                    xorFrequency.getOrDefault(prefixXOR, 0) + 1);
        }

        System.out.println(subarrayCount);

        sc.close();
    }
}

/*
------------------------------------------------------------
Dry Run

Input:
nums = [4, 2, 2, 6, 4]
k = 6

Prefix XOR:

4
6
4
2
6

Map stores frequencies of prefix XORs.

Whenever:
prefixXOR ^ k
already exists in the map,
a valid subarray is found.

Answer = 4

Key Observation:
Suppose

Current Prefix XOR = P

We need a previous Prefix XOR = X

such that:

X ^ P = k

Therefore,

X = P ^ k

Hence, checking (prefixXOR ^ k) in the HashMap
tells us how many valid subarrays end at the
current index.

------------------------------------------------------------
*/