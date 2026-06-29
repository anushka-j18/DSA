import java.util.Arrays;
import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Set Matrix Zeroes
Platform: TUF A2Z DSA Sheet
Topic   : Arrays
Difficulty: Medium

Approach (Optimal - O(1) Extra Space):
1. Use the first row and first column as markers.
2. If matrix[i][j] == 0:
      - Mark its row by setting matrix[i][0] = 0.
      - Mark its column by setting matrix[0][j] = 0.
3. Keep a separate variable (col0) to track whether
   the first column should become zero.
4. Traverse the matrix again (excluding first row/column)
   and set cells to 0 based on the markers.
5. Finally, update the first row and first column if needed.

Time Complexity : O(m × n)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class SetMatrixZeroes {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read matrix dimensions
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];

        // Read matrix elements
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int col0 = 1;

        // Step 1: Mark rows and columns
        for (int i = 0; i < rows; i++) {

            if (matrix[i][0] == 0) {
                col0 = 0;
            }

            for (int j = 1; j < cols; j++) {

                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Step 2: Update matrix using markers
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {

                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 3: Update first row
        if (matrix[0][0] == 0) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }

        // Step 4: Update first column
        if (col0 == 0) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }

        // Print the updated matrix
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
1 1 1
1 0 1
1 1 1

Step 1 (Mark):
1 0 1
0 0 1
1 1 1

Step 2:
1 0 1
0 0 0
1 0 1

Output:
[1, 0, 1]
[0, 0, 0]
[1, 0, 1]

Key Observation:
Instead of using extra arrays for rows and columns,
reuse the first row and first column as markers,
achieving O(1) extra space.

------------------------------------------------------------
*/