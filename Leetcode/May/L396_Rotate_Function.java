package Leetcode.May;

public class L396_Rotate_Function {
    public static void main(String[] args) {
        int[] nums = {4,3,2,6};
        Solution sol = new Solution();
//        System.out.println(Arrays.toString(sol.rotate(nums, 2)));
        System.out.println(sol.maxRotateFunction(nums));
    }
}

class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int f = 0;

        // Initial sum and F(0)
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f += i * nums[i];
        }

        int max = f;

        // Compute F(1) to F(n-1)
        for (int k = 1; k < n; k++) {
            f = f + sum - n * nums[n - k];
            max = Math.max(max, f);
        }

        return max;
    }
}
