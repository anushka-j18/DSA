import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Single Number - I
Platform: TUF A2Z DSA Sheet
Topic   : Arrays
Difficulty: Easy

Approach:
1. Traverse the array once.
2. XOR all the elements.
3. Duplicate elements cancel each other because:
      a ^ a = 0
      a ^ 0 = a
4. The remaining value is the element that appears only once.

Time Complexity : O(n)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class SingleNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read array size
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Read array elements
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int singleNumber = 0;

        // XOR every element
        for (int num : nums) {
            singleNumber ^= num;
        }

        // Print the unique element
        System.out.println(singleNumber);

        sc.close();
    }
}