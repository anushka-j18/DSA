import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Painter's Partition Problem

Approach:
1. The minimum possible workload for a painter is the
   length of the largest board.
2. The maximum possible workload is the sum of all
   board lengths.
3. Apply Binary Search on the maximum board length
   assigned to a painter.
4. For every candidate workload:
      - Greedily assign contiguous boards.
      - Count the number of painters required.
5. If the required painters are less than or equal to A,
   try a smaller workload.
6. Otherwise, increase the workload.
7. Multiply the final workload by B and return the result
   modulo 10000003.

Time Complexity : O(n × log(sum of board lengths))
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class PaintersPartition {

    static final int MOD = 10000003;

    // Returns the number of painters required
    static int countPainters(int[] boards, long maxLength) {

        int painters = 1;
        long currentLength = 0;

        for (int board : boards) {

            if (currentLength + board <= maxLength) {

                currentLength += board;

            } else {

                painters++;
                currentLength = board;
            }
        }

        return painters;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read number of painters
        int A = sc.nextInt();

        // Read time per unit
        int B = sc.nextInt();

        // Read number of boards
        int n = sc.nextInt();

        int[] boards = new int[n];

        long maxBoard = 0;
        long totalLength = 0;

        // Read board lengths
        for (int i = 0; i < n; i++) {
            boards[i] = sc.nextInt();
            maxBoard = Math.max(maxBoard, boards[i]);
            totalLength += boards[i];
        }

        long low = maxBoard;
        long high = totalLength;
        long answer = totalLength;

        while (low <= high) {

            long mid = low + (high - low) / 2;

            int painters = countPainters(boards, mid);

            if (painters <= A) {

                answer = mid;
                high = mid - 1;

            } else {

                low = mid + 1;
            }
        }

        long minimumTime = (answer * B) % MOD;

        System.out.println(minimumTime);

        sc.close();
    }
}

/*
------------------------------------------------------------
Dry Run

Input:
A = 2
B = 5
Boards = [1, 10]

Search Space:
10 ... 11

mid = 10

Painter 1:
1

Painter 2:
10

Painters = 2

Possible.

Try smaller workload.

--------------------------------------------

Answer = 10 units

Time = 10 × 5 = 50

50 % 10000003 = 50

Output:
50

Key Observation:
If a workload 'X' can be assigned using A painters,
then every workload greater than X is also feasible.

This monotonic property allows Binary Search
on the answer.

------------------------------------------------------------
*/