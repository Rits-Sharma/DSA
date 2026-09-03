package Leetcode.July;

import java.util.Arrays;

public class L628_Maximum_Product_of_Three_Numbers {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(maximumProduct(nums));
    }

    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int a = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int b = nums[0] * nums[1] * nums[n - 1];
        return Math.max(a, b);
    }
}
