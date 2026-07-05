import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Search in a 2D Matrix

Approach:
1. Treat the 2D matrix as a single sorted 1D array.
2. Apply Binary Search on the range:
      0 to (rows × columns - 1).
3. Convert the 1D index into 2D coordinates:
      row = mid / columns
      column = mid % columns
4. Compare the current element with the target.
5. Return true if found, otherwise false.

Time Complexity : O(log(rows × columns))
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class SearchIn2DMatrix {

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

        // Read target
        int target = sc.nextInt();

        int low = 0;
        int high = rows * cols - 1;

        boolean found = false;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int row = mid / cols;
            int col = mid % cols;

            if (mat[row][col] == target) {

                found = true;
                break;

            } else if (mat[row][col] < target) {

                low = mid + 1;

            } else {

                high = mid - 1;
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

1  2  3  4
5  6  7  8
9 10 11 12

Target = 8

rows = 3
cols = 4

Search Space:
0 ... 11

mid = 5

row = 5 / 4 = 1
col = 5 % 4 = 1

Element = 6

6 < 8

Search right.

--------------------------------------------

mid = 8

row = 2
col = 0

Element = 9

9 > 8

Search left.

--------------------------------------------

mid = 7

row = 1
col = 3

Element = 8

Target found.

Output:
true

Key Observation:
Since each row is sorted and the first element of every
row is greater than the last element of the previous row,
the entire matrix behaves like one sorted 1D array.

------------------------------------------------------------
*/