package Leetcode.June;

import java.util.Arrays;

public class L2144_Minimum_Cost_of_Buying_Candies {
    public static void main(String[] args) {
        int[] cost = {6,5,7,9,2,2};
        System.out.println(minimumCost(cost));
    }

    public static int minimumCost(int[] cost) {
        int n = cost.length;
        int costSum = 0;
        Arrays.sort(cost);

        int curr = 1;

        for (int i = n-1; i >= 0; i--) {
            if (curr%3 != 0) {
                costSum += cost[i];
            }
            curr++;
        }
        return costSum;
    }
}
