package Leetcode;

public class L3418_Maximum_Amount_of_Money {
    public static void main(String[] args) {
        int[][] coinsMatrix = {{0,1,-1}, {1,-2,3}, {2,-3,4}};
        System.out.println(maximumAmount(coinsMatrix));
    }

    public static int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;

        int[][][] dp = new int[m][n][3];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE / 2;
                }
            }
        }

        // Start
        dp[0][0][0] = coins[0][0];
        if (coins[0][0] < 0) {
            dp[0][0][1] = 0; // neutralize start
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    if (dp[i][j][k] == Integer.MIN_VALUE / 2) continue;

                    // DOWN
                    if (i + 1 < m) {
                        int val = coins[i + 1][j];

                        if (val >= 0) {
                            dp[i + 1][j][k] = Math.max(dp[i + 1][j][k], dp[i][j][k] + val);
                        } else {
                            // don't neutralize
                            dp[i + 1][j][k] = Math.max(dp[i + 1][j][k], dp[i][j][k] + val);

                            // neutralize
                            if (k < 2) {
                                dp[i + 1][j][k + 1] = Math.max(dp[i + 1][j][k + 1], dp[i][j][k]);
                            }
                        }
                    }

                    // RIGHT
                    if (j + 1 < n) {
                        int val = coins[i][j + 1];

                        if (val >= 0) {
                            dp[i][j + 1][k] = Math.max(dp[i][j + 1][k], dp[i][j][k] + val);
                        } else {
                            // don't neutralize
                            dp[i][j + 1][k] = Math.max(dp[i][j + 1][k], dp[i][j][k] + val);

                            // neutralize
                            if (k < 2) {
                                dp[i][j + 1][k + 1] = Math.max(dp[i][j + 1][k + 1], dp[i][j][k]);
                            }
                        }
                    }
                }
            }
        }

        return Math.max(dp[m - 1][n - 1][0],
                Math.max(dp[m - 1][n - 1][1], dp[m - 1][n - 1][2]));
    }
}
