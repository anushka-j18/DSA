import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Median in a Row-wise Sorted Matrix

Approach:
1. The median lies between the minimum element of the
   first column and the maximum element of the last column.
2. Apply Binary Search on the value range.
3. For every candidate value:
      - Count how many elements are less than or equal
        to the candidate.
      - Use Binary Search (Upper Bound) in each row to
        compute this count efficiently.
4. If the count is less than or equal to half of the
   total elements, search for a larger value.
5. Otherwise, search for a smaller value.
6. The final low value is the median.

Time Complexity : O(rows × log(columns) × log(valueRange))
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class MedianInRowWiseSortedMatrix {

    // Returns number of elements <= target in a row
    static int upperBound(int[] row, int target) {

        int low = 0;
        int high = row.length - 1;
        int answer = row.length;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (row[mid] > target) {

                answer = mid;
                high = mid - 1;

            } else {

                low = mid + 1;
            }
        }

        return answer;
    }

    // Counts elements <= target in the matrix
    static int countSmallerEqual(int[][] matrix, int target) {

        int count = 0;

        for (int[] row : matrix) {
            count += upperBound(row, target);
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read rows and columns
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];

        // Read matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Find minimum and maximum values
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int i = 0; i < rows; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][cols - 1]);
        }

        int required = (rows * cols) / 2;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int count = countSmallerEqual(matrix, mid);

            if (count <= required) {

                low = mid + 1;

            } else {

                high = mid - 1;
            }
        }

        System.out.println(low);

        sc.close();
    }
}

/*
------------------------------------------------------------
Dry Run

Input:

1 4 9
2 5 6
3 7 8

Minimum = 1
Maximum = 9

Search Space:
1 ... 9

mid = 5

Elements <= 5:

Row 1:
1 4 -> 2

Row 2:
2 5 -> 2

Row 3:
3 -> 1

Total = 5

Required = 4

5 > 4

Search left.

--------------------------------------------

Eventually,

Median = 5

Output:
5

Key Observation:
Instead of merging or sorting all elements,
Binary Search is performed on the value range.

For each candidate value, Binary Search (Upper Bound)
on every row counts how many elements are less than
or equal to it.

------------------------------------------------------------
*/