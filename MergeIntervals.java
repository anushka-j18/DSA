import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Merge Overlapping Subintervals
Platform: TUF A2Z DSA Sheet
Topic   : Arrays
Difficulty: Medium

Approach:
1. Sort the intervals based on their starting time.
2. Add the first interval to the result list.
3. Traverse the remaining intervals:
      - If the current interval overlaps with the last
        interval in the result, merge them.
      - Otherwise, add the current interval as a new interval.
4. Print all merged intervals.

Time Complexity : O(n log n)
Space Complexity: O(n)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class MergeIntervals {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read number of intervals
        int n = sc.nextInt();

        int[][] intervals = new int[n][2];

        // Read intervals
        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }

        // Sort intervals by starting point
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> mergedIntervals = new ArrayList<>();

        // Add the first interval
        mergedIntervals.add(intervals[0]);

        // Traverse remaining intervals
        for (int i = 1; i < n; i++) {

            int[] lastInterval = mergedIntervals.get(mergedIntervals.size() - 1);

            // Check for overlap
            if (intervals[i][0] <= lastInterval[1]) {

                // Merge intervals
                lastInterval[1] = Math.max(lastInterval[1], intervals[i][1]);

            } else {

                // No overlap, add new interval
                mergedIntervals.add(intervals[i]);
            }
        }

        // Print merged intervals
        for (int[] interval : mergedIntervals) {
            System.out.println(Arrays.toString(interval));
        }

        sc.close();
    }
}

/*
------------------------------------------------------------
Dry Run

Input:
[[1,5],[3,6],[8,10],[15,18]]

After Sorting:
[[1,5],[3,6],[8,10],[15,18]]

Result:
[1,5]

Compare:
[3,6]

Overlap:
1 <= 6

Merge:
[1,6]

Next:
[8,10]

No overlap

Result:
[1,6]
[8,10]

Next:
[15,18]

No overlap

Final Output:
[1,6]
[8,10]
[15,18]

Key Observation:
After sorting, any overlapping intervals
will always be adjacent.

------------------------------------------------------------
*/