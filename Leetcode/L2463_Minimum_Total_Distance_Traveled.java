package Leetcode;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class L2463_Minimum_Total_Distance_Traveled {
    public static void main(String[] args) {

    }

    public static long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));

        List<Integer> factoryPositions = new java.util.ArrayList<>();
        for (int[] f : factory) {
            for (int i = 0; i < f[1]; i++) {
                factoryPositions.add(f[0]);
            }
        }

        int n = robot.size();
        int m = factoryPositions.size();
        long[][] dp = new long[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            dp[i][m] = (long) 1e15;
        }

        for (int j = m - 1; j >= 0; j--) {
            for (int i = n - 1; i >= 0; i--) {
                long assign = Math.abs((long) robot.get(i) - factoryPositions.get(j)) + dp[i + 1][j + 1];
                long skip = dp[i][j + 1];
                dp[i][j] = Math.min(assign, skip);
            }
        }
        return dp[0][0];
    }
}
