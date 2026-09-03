package Leetcode.July;

import java.util.Arrays;

public class L3336_Number_of_Subsequences_With_Equal_GCD {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(subsequencePairCount(nums));
    }


    static int mod = 1_000_000_007;
    static int[][][] dp;

    public static int subsequencePairCount(int[] nums) {
        int n = nums.length, max = 0;
        for (int num : nums) max = Math.max(max, num);

        dp = new int[n][max+1][max+1];
        for (int i = 0; i < n; i++) {
            for (int[] arr : dp[i]) {
                Arrays.fill(arr, -1);
            }
        }

        return helper(0, 0, 0, nums);
    }

    public static int helper(int i, int seq1, int seq2, int[] nums) {
        if (i == nums.length) {
            if (seq1 != seq2 || seq1 == 0) return 0;
            else return 1;
        }

        if (dp[i][seq1][seq2] != -1) return dp[i][seq1][seq2];

        long take1 = helper(i+1, gcd(nums[i], seq1), seq2, nums);
        long take2 = helper(i+1, seq1, gcd(nums[i], seq2), nums);
        long skip = helper(i+1, seq1, seq2, nums);

        long ans = (take1 % mod + take2 % mod + skip % mod) % mod;

        return dp[i][seq1][seq2] = (int) ans;
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
