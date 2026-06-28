import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Best Time to Buy and Sell Stock
Platform: TUF A2Z DSA Sheet
Topic   : Arrays
Difficulty: Easy

Approach:
1. Keep track of the minimum stock price encountered so far.
2. For each day's price:
      - Calculate the profit if the stock is sold today.
      - Update the maximum profit if the current profit is higher.
      - Update the minimum buying price if a lower price is found.
3. The maximum profit obtained is the answer.

Time Complexity : O(n)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read the number of days
        int n = sc.nextInt();

        int[] prices = new int[n];

        // Read stock prices
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        // Minimum price seen so far
        int minimumPrice = prices[0];

        // Maximum profit that can be earned
        int maximumProfit = 0;

        // Traverse the price array
        for (int i = 1; i < n; i++) {

            // Profit obtained if sold on the current day
            int currentProfit = prices[i] - minimumPrice;

            // Update maximum profit
            if (currentProfit > maximumProfit) {
                maximumProfit = currentProfit;
            }

            // Update minimum buying price
            if (prices[i] < minimumPrice) {
                minimumPrice = prices[i];
            }
        }

        System.out.println(maximumProfit);

        sc.close();
    }
}

/*
------------------------------------------------------------
Dry Run

Input:
[10, 7, 5, 8, 11, 9]

Day    Price    Min Price    Profit    Max Profit

1       10         10           -            0
2        7          7          -3            0
3        5          5          -2            0
4        8          5           3            3
5       11          5           6            6
6        9          5           4            6

Answer = 6

Key Observation:
To maximize profit, always buy at the lowest price seen so far
and calculate the profit for every future selling price.

------------------------------------------------------------
*/