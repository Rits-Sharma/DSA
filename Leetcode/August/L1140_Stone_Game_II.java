package Leetcode.August;

public class L1140_Stone_Game_II {
    public static void main(String[] args) {
        int[] piles = {2,7,9,4,4};
        System.out.println(stoneGameII(piles));
    }

    private static int[] suffixSum;
    private static Integer[][] memo;

    public static int stoneGameII(int[] piles) {
        int n = piles.length;
        suffixSum = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        memo = new Integer[n][n + 1];
        return dfs(0, 1, n);
    }

    private static int dfs(int i, int m, int n) {
        if (2 * m >= n - i) {
            return suffixSum[i];
        }

        if (memo[i][m] != null) {
            return memo[i][m];
        }

        int maxStones = 0;
        for (int x = 1; x <= 2 * m; x++) {
            maxStones = Math.max(maxStones, suffixSum[i] - dfs(i + x, Math.max(m, x), n));
        }

        return memo[i][m] = maxStones;
    }
}
