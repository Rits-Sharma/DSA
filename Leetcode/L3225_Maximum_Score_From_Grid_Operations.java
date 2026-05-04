package Leetcode;

import java.util.Arrays;

public class L3225_Maximum_Score_From_Grid_Operations {
    public static void main(String[] args) {
        int[][] grid = {{10,9,0,0,15}, {7,1,0,8,0}, {5,20,0,11,0}, {0,0,0,1,2}, {8,12,1,10,3}};
        L3225_Maximum_Score_From_Grid_Operations sol = new L3225_Maximum_Score_From_Grid_Operations();
        System.out.println(sol.maximumScore(grid));
    }

    long[][] pref;
    int[][] grid;
    int n;
    long[][][] dp;
    public long maximumScore(int[][] grid) {
        this.grid = grid;
        n = grid.length;

        pref = new long[n+1][n+1];
        dp = new long[2][n+1][n+1];

        for(int j=0; j<n; j++) {
            for(int i=1; i<=n; i++) {
                pref[i][j+1] = pref[i-1][j+1] + grid[i-1][j];
            }
        }

        for(int i=0; i<2; i++) {
            for(int j=0; j<=n; j++)
                Arrays.fill(dp[i][j], -1);
        }

        return helper(0,0,1);
    }

    long helper(int prevTaken, int prevLen, int col) {
        // O(n^3)
        if(col==n+1)
            return 0;
        if(dp[prevTaken][prevLen][col]!=-1)
            return dp[prevTaken][prevLen][col];

        long ans = 0;

        for(int len=0; len<=n; len++) {
            long prevans = 0, currans = 0;

            if(prevTaken==0 && col>1 && len > prevLen) {
                prevans = pref[len][col-1] - pref[prevLen][col-1];
            }

            // currans
            if(prevLen > len) {
                currans = pref[prevLen][col] - pref[len][col];
            }

            long ans1 = currans + prevans + helper(1, len, col+1);
            long ans2 = prevans + helper(0, len, col+1);

            ans = Math.max(ans, Math.max(ans1, ans2));
        }

        return dp[prevTaken][prevLen][col] = ans;
    }

    public boolean maxPathScore(int[][] grid, int k) {
        return false;
    }
}
