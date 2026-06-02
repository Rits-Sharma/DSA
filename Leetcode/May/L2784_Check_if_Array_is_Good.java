package Leetcode.May;

import java.util.Arrays;

public class L2784_Check_if_Array_is_Good {
    public static void main(String[] args) {
        int[] nums = {2,1,3};
        System.out.println(isGood(nums));
    }

    public static boolean isGood(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] != i + 1) return false;
        }
        return nums[n - 1] == n - 1;
    }
}
