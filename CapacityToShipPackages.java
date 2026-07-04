import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Capacity To Ship Packages Within D Days

Approach:
1. The minimum possible ship capacity is the maximum weight
   among all packages (since every package must be shipped).
2. The maximum possible capacity is the sum of all package
   weights (ship everything in one day).
3. Apply Binary Search on the ship capacity.
4. For each capacity:
      - Simulate the shipping process.
      - Count the number of days required.
5. If the required days are less than or equal to the
   given days, try a smaller capacity.
6. Otherwise, increase the capacity.

Time Complexity : O(n × log(sum of weights))
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class CapacityToShipPackages {

    // Calculate days required for a given ship capacity
    static int calculateDays(int[] weights, int capacity) {

        int days = 1;
        int currentLoad = 0;

        for (int weight : weights) {

            if (currentLoad + weight <= capacity) {

                currentLoad += weight;

            } else {

                days++;
                currentLoad = weight;
            }
        }

        return days;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read number of packages
        int n = sc.nextInt();

        int[] weights = new int[n];

        int maxWeight = 0;
        int totalWeight = 0;

        // Read package weights
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
            maxWeight = Math.max(maxWeight, weights[i]);
            totalWeight += weights[i];
        }

        // Read number of days
        int days = sc.nextInt();

        int low = maxWeight;
        int high = totalWeight;
        int answer = totalWeight;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int requiredDays = calculateDays(weights, mid);

            if (requiredDays <= days) {

                answer = mid;
                high = mid - 1;

            } else {

                low = mid + 1;
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
weights = [1,2,3,4,5,6,7,8,9,10]
days = 5

Search Space:
10 ... 55

mid = 32

Days Required:
[1+2+3+4+5+6+7] = 28
[8+9] = 17
[10]

Days = 3

Possible answer.
Try smaller capacity.

--------------------------------------------

mid = 15

Days Required:

Day 1:
1+2+3+4+5 = 15

Day 2:
6+7 = 13

Day 3:
8

Day 4:
9

Day 5:
10

Days = 5

Valid answer.

Output:
15

Key Observation:
As ship capacity increases,
the number of days required never increases.

This monotonic property allows Binary Search
on the answer.

------------------------------------------------------------
*/