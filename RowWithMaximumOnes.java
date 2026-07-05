import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Row with Maximum Number of 1's

Approach:
1. Since every row is sorted, use Binary Search to find
   the first occurrence of 1 in each row.
2. Number of 1's in a row =
      columns - firstOccurrenceIndex.
3. Keep track of the row having the maximum number of 1's.
4. If no row contains a 1, return -1.

Time Complexity : O(rows × log(columns))
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class RowWithMaximumOnes {

    // Returns the index of the first occurrence of 1
    static int firstOne(int[] row) {

        int low = 0;
        int high = row.length - 1;
        int answer = row.length;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (row[mid] == 1) {

                answer = mid;
                high = mid - 1;

            } else {

                low = mid + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read rows and columns
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] mat = new int[rows][cols];

        // Read matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        int maxOnes = 0;
        int answer = -1;

        for (int i = 0; i < rows; i++) {

            int firstIndex = firstOne(mat[i]);
            int ones = cols - firstIndex;

            if (ones > maxOnes) {

                maxOnes = ones;
                answer = i;
            }
        }

        System.out.println(answer);

        sc.close();
    }
}

/*
------------------------------------------------------------
Dry Run

Input:

1 1 1
0 0 1
0 0 0

Row 0:

First 1 = index 0

Ones = 3

Maximum = 3

--------------------------------------------

Row 1:

First 1 = index 2

Ones = 1

No update.

--------------------------------------------

Row 2:

No 1 found

Ones = 0

No update.

Output:
0

--------------------------------------------

Input:

0 0
0 0

No row contains a 1.

Output:
-1

Key Observation:
Since every row is sorted,
Binary Search can efficiently find the first occurrence
of 1 in each row, allowing us to compute the number of
1's without scanning the entire row.

------------------------------------------------------------
*/