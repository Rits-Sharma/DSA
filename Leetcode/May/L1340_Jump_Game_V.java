package Leetcode.May;

public class L1340_Jump_Game_V {
    public static void main(String[] args) {
        int[] arr = {6,4,14,6,8,13,9,7,10,6,12};
        int d = 2;
        System.out.println(maxJumps(arr, d));
    }

    public static int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] dp = new int[n];
        int maxResult = 0;
        for (int i = 0; i < n; i++) {
            maxResult = Math.max(maxResult, dfs(arr, d, i, dp));
        }
        return maxResult;
    }

    private static int dfs(int[] arr, int d, int i, int[] dp) {
        if (dp[i] != 0) {
            return dp[i];
        }
        int n = arr.length;
        int maxJumpsFromI = 1;
        for (int x = i + 1; x <= Math.min(i + d, n - 1); x++) {
            if (arr[x] >= arr[i]) {
                break;
            }
            maxJumpsFromI = Math.max(maxJumpsFromI, 1 + dfs(arr, d, x, dp));
        }
        for (int x = i - 1; x >= Math.max(0, i - d); x--) {
            if (arr[x] >= arr[i]) {
                break;
            }
            maxJumpsFromI = Math.max(maxJumpsFromI, 1 + dfs(arr, d, x, dp));
        }
        dp[i] = maxJumpsFromI;
        return dp[i];
    }
}
