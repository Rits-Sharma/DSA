package Striver_DSA_Sheet.Array;

import java.util.Map;

public class Kadane_Algorithm {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int curr = nums[0];

        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(curr + nums[i], nums[i]);
            max = Math.max(max, curr);
        }

        return max;
    }
}
