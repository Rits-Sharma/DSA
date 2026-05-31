package Leetcode;

public class L1674_Minimum_Moves {
    public static void main(String[] args) {
        int[] nums = {1,2,4,3};
        int limit = 4;
        System.out.println(minMoves(nums, limit));
    }

    public static int minMoves(int[] nums, int limit) {
        int n = nums.length;
        // The maximum possible sum is 2 * limit.
        // We need size up to 2 * limit + 2 to handle boundary increments safely.
        int[] diff = new int[2 * limit + 2];

        for (int i = 0; i < n / 2; i++) {
            int a = Math.min(nums[i], nums[n - 1 - i]);
            int b = Math.max(nums[i], nums[n - 1 - i]);

            // Base case: Assume 2 moves are needed for all target sums starting from 2
            diff[2] += 2;

            // Interval [1 + a, a + b - 1]: We only need 1 move instead of 2. (-1 move)
            diff[1 + a] -= 1;

            // Point a + b: We need 0 moves instead of 1. (-1 move again)
            diff[a + b] -= 1;

            // Interval [a + b + 1, b + limit]: We need 1 move again instead of 0. (+1 move)
            diff[a + b + 1] += 1;

            // Interval [b + limit + 1, 2 * limit]: We need 2 moves again instead of 1. (+1 move)
            diff[b + limit + 1] += 1;
        }

        int minMoves = n; // Max possible moves is changing every element
        int currentMoves = 0;

        // Calculate the prefix sum to find the moves needed for each target sum T
        for (int T = 2; T <= 2 * limit; T++) {
            currentMoves += diff[T];
            minMoves = Math.min(minMoves, currentMoves);
        }

        return minMoves;
    }
}
