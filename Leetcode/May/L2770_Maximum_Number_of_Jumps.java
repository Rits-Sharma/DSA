package Leetcode.May;

import java.util.Arrays;

public class L2770_Maximum_Number_of_Jumps {
    public static void main(String[] args) {
        int[] nums = {1,3,6,4,1,2};
        int target = 2;
        System.out.println(maximumJumps(nums, target));
    }

    public static int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        // dp[i] stores the maximum number of jumps to reach index i from index 0.
        // Initialize with -1 to indicate not reachable.
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        // Base case: 0 jumps to reach the starting index.
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // If index j is reachable and a jump from j to i is valid
                if (dp[j] != -1 && Math.abs(nums[i] - nums[j]) <= target) {
                    // Update dp[i] with the maximum jumps
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }
        return dp[n - 1];
    }
}
