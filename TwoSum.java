import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Two Sum
Platform: TUF A2Z DSA Sheet
Topic   : Arrays + Hashing
Difficulty: Easy

Approach:
1. Traverse the array once.
2. For every element, calculate the required complement:
      complement = target - currentElement
3. Check if the complement already exists in the HashMap.
4. If it exists, we have found the required pair of indices.
5. Otherwise, store the current element and its index in the map.

Time Complexity : O(n)
Space Complexity: O(n)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class TwoSum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read array size
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Read array elements
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Read target
        int target = sc.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>();

        int[] answer = new int[2];

        for (int i = 0; i < n; i++) {

            int complement = target - nums[i];

            // If complement exists, answer is found
            if (map.containsKey(complement)) {
                answer[0] = map.get(complement);
                answer[1] = i;
                break;
            }

            // Store current element and its index
            map.put(nums[i], i);
        }

        System.out.println(Arrays.toString(answer));

        sc.close();
    }
}