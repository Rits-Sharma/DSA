package Leetcode.June;

import java.util.Arrays;

public class L1833_Maximum_Ice_Cream_Bars {
    public static void main(String[] args) {
        int[] costs = {1,3,2,4,1};
        int coins = 7;
        System.out.println(maxIceCream(costs, coins));
    }

    public static int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        int noOfBars = 0;

        for (int c : costs) {
            if (coins >= c) {
                noOfBars++;
                coins -= c;
            }
        }
        return noOfBars;
    }
}
