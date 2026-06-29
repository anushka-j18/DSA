import java.util.Arrays;
import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Rotate Matrix by 90 Degrees
Platform: TUF A2Z DSA Sheet
Topic   : Arrays (Matrix)
Difficulty: Medium

Approach:
1. Transpose the matrix.
   - Swap matrix[i][j] with matrix[j][i].
2. Reverse every row.
3. The resulting matrix is rotated by 90° clockwise.

Time Complexity : O(n²)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class RotateMatrix90Degrees {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read matrix size (N x N)
        int n = sc.nextInt();

        int[][] matrix = new int[n][n];

        // Read matrix elements
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse every row
        for (int i = 0; i < n; i++) {

            int left = 0;
            int right = n - 1;

            while (left < right) {

                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }

        // Print the rotated matrix
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

        sc.close();
    }
}

/*
------------------------------------------------------------
Dry Run

Input:
1 2 3
4 5 6
7 8 9

Step 1: Transpose

1 4 7
2 5 8
3 6 9

Step 2: Reverse each row

7 4 1
8 5 2
9 6 3

Output:
[7, 4, 1]
[8, 5, 2]
[9, 6, 3]

Key Observation:
A 90° clockwise rotation can be achieved by:
1. Transposing the matrix.
2. Reversing each row.

------------------------------------------------------------
*/