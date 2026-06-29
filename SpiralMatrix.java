import java.util.ArrayList;
import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Print Matrix in Spiral Order
Platform: TUF A2Z DSA Sheet
Topic   : Arrays (Matrix)
Difficulty: Medium

Approach:
1. Maintain four boundaries:
      - top
      - bottom
      - left
      - right
2. Traverse:
      a) Left → Right
      b) Top → Bottom
      c) Right → Left
      d) Bottom → Top
3. After every traversal, shrink the corresponding boundary.
4. Continue until all elements are visited.

Time Complexity : O(m × n)
Space Complexity: O(m × n)    // Output list only

Author: Anushka Joshi
------------------------------------------------------------
*/

public class SpiralMatrix {

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

        ArrayList<Integer> spiralOrder = new ArrayList<>();

        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = cols - 1;

        while (top <= bottom && left <= right) {

            // Traverse Left → Right
            for (int j = left; j <= right; j++) {
                spiralOrder.add(matrix[top][j]);
            }
            top++;

            // Traverse Top → Bottom
            for (int i = top; i <= bottom; i++) {
                spiralOrder.add(matrix[i][right]);
            }
            right--;

            // Traverse Right → Left
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    spiralOrder.add(matrix[bottom][j]);
                }
                bottom--;
            }

            // Traverse Bottom → Top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    spiralOrder.add(matrix[i][left]);
                }
                left++;
            }
        }

        System.out.println(spiralOrder);

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

Step 1:
→ 1 2 3

Step 2:
↓ 6 9

Step 3:
← 8 7

Step 4:
↑ 4

Remaining:
5

Output:
[1, 2, 3, 6, 9, 8, 7, 4, 5]

Key Observation:
The matrix is traversed layer by layer by continuously
shrinking the four boundaries:
Top, Bottom, Left and Right.

------------------------------------------------------------
*/