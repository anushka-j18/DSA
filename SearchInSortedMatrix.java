import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Search in a Row-wise and Column-wise Sorted Matrix

Approach:
1. Start from the top-right corner of the matrix.
2. Compare the current element with the target.
3. If the current element equals the target,
   return true.
4. If the current element is greater than the target,
   move left.
5. Otherwise, move down.
6. Continue until the target is found or the indices
   go out of bounds.

Time Complexity : O(rows + columns)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class SearchInSortedMatrix {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read number of rows and columns
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];

        // Read matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Read target
        int target = sc.nextInt();

        int row = 0;
        int col = cols - 1;

        boolean found = false;

        while (row < rows && col >= 0) {

            if (matrix[row][col] == target) {

                found = true;
                break;

            } else if (matrix[row][col] > target) {

                col--;

            } else {

                row++;
            }
        }

        System.out.println(found);

        sc.close();
    }
}

/*
------------------------------------------------------------
Dry Run

Input:

1   4   7   11  15
2   5   8   12  19
3   6   9   16  22
10 13  14  17  24
18 21  23  26  30

Target = 5

Start at top-right:

15 > 5

Move left.

--------------------------------------------

11 > 5

Move left.

--------------------------------------------

7 > 5

Move left.

--------------------------------------------

4 < 5

Move down.

--------------------------------------------

Current = 5

Target found.

Output:
true

Key Observation:
At the top-right corner:
- Every element to the left is smaller.
- Every element below is larger.

Thus, one row or one column can be eliminated
in every step.

------------------------------------------------------------
*/