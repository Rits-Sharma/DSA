package Striver_DSA_Sheet.Array;

public class L121_Stock_Buy_Sell {
    public static void main(String[] args) {
        int[] stocks = {2,4,1};
        System.out.println(maxProfit(stocks));
    }

    public static int maxProfit(int[] prices) {
        int min = prices[0], index = 0;
        int n = prices.length;

        for (int i = 1; i < n; i++) {
            if (prices[i] < min) {
                min = prices[i];
                index = i;
            }
        }
        int max = prices[index];
        for (int i = index+1; i < n; i++) {
            if (prices[i] > max) {
                max = prices[i];
            }
        }
        System.out.println(min + " " + max);
        return max - min;
    }
}
