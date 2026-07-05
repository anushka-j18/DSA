import java.util.Arrays;
import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Find a Peak Element in a 2D Matrix

Approach:
1. Apply Binary Search on the columns.
2. For the current middle column:
      - Find the row having the maximum element.
3. Compare this element with its left and right neighbours.
4. If it is greater than both neighbours,
   then it is a peak.
5. If the left neighbour is greater,
   search in the left half.
6. Otherwise,
   search in the right half.

Time Complexity : O(rows × log(columns))
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class FindPeakElement2D {

    // Returns the row index having the maximum element
    // in the given column
    static int findMaxRow(int[][] mat, int col) {

        int maxRow = 0;

        for (int i = 1; i < mat.length; i++) {

            if (mat[i][col] > mat[maxRow][col]) {
                maxRow = i;
            }
        }

        return maxRow;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read number of rows and columns
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] mat = new int[rows][cols];

        // Read matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        int low = 0;
        int high = cols - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int maxRow = findMaxRow(mat, mid);

            int left = (mid > 0) ? mat[maxRow][mid - 1] : -1;
            int right = (mid < cols - 1) ? mat[maxRow][mid + 1] : -1;

            // Peak found
            if (mat[maxRow][mid] > left &&
                mat[maxRow][mid] > right) {

                System.out.println(Arrays.toString(new int[]{maxRow, mid}));
                return;
            }

            // Search left half
            else if (left > mat[maxRow][mid]) {

                high = mid - 1;
            }

            // Search right half
            else {

                low = mid + 1;
            }
        }

        sc.close();
    }
}

/*
------------------------------------------------------------
Dry Run

Input:

10 20 15
21 30 14
7  16 32

Search on Columns

low = 0
high = 2

mid = 1

Column 1:

20
30
16

Maximum = 30
at row = 1

Left = 21
Right = 14

30 > 21
30 > 14

Peak found.

Answer:
[1, 1]

--------------------------------------------

Key Observation:
Instead of checking every cell,
Binary Search is applied on columns.

For every middle column,
only the maximum element is considered because
if a peak exists in that column, it must be at
its maximum element.

------------------------------------------------------------
*/