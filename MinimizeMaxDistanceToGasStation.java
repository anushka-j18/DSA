import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Minimize Max Distance to Gas Station

Approach:
1. The answer lies between:
      - 0 (minimum possible distance)
      - Maximum distance between two consecutive stations.
2. Apply Binary Search on the answer (double values).
3. For every candidate distance:
      - Calculate how many new gas stations are required
        so that no gap exceeds the candidate distance.
4. If required stations > k,
      increase the distance.
5. Otherwise,
      try a smaller distance.
6. Continue until the precision reaches 1e-6.

Time Complexity : O(n × log(maxDistance / 1e-6))
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class MinimizeMaxDistanceToGasStation {

    // Returns the number of gas stations required
    static int numberOfGasStationsRequired(int[] arr, double distance) {

        int count = 0;

        for (int i = 1; i < arr.length; i++) {

            double gap = arr[i] - arr[i - 1];

            int stations = (int) (gap / distance);

            // If the gap is exactly divisible, one station is overcounted
            if (Math.abs(gap - stations * distance) < 1e-9) {
                stations--;
            }

            count += stations;
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read number of gas stations
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Read positions
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Read number of new gas stations
        int k = sc.nextInt();

        double low = 0;
        double high = 0;

        // Find maximum gap
        for (int i = 1; i < n; i++) {
            high = Math.max(high, arr[i] - arr[i - 1]);
        }

        // Binary Search on answer
        while (high - low > 1e-6) {

            double mid = low + (high - low) / 2.0;

            int requiredStations = numberOfGasStationsRequired(arr, mid);

            if (requiredStations > k) {

                low = mid;

            } else {

                high = mid;
            }
        }

        System.out.printf("%.6f%n", high);

        sc.close();
    }
}

/*
------------------------------------------------------------
Dry Run

Input:
arr = [1,2,3,4,5,6,7,8,9,10]
k = 10

Maximum Gap = 1

Search Space:
0 ... 1

mid = 0.5

Each gap = 1

Stations required per gap:
1

Total = 9

9 <= 10

Possible.

Try smaller distance.

Eventually,

Answer = 0.500000

--------------------------------------------

Input:
arr = [1,2,3,4,5,6,7,8,9,10]
k = 1

Gap = 1

No smaller maximum distance can be achieved.

Answer = 1.000000

Key Observation:
As the allowed maximum distance increases,
the number of required gas stations decreases.

This monotonic property allows Binary Search
on the answer.

------------------------------------------------------------
*/