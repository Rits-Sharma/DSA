package Leetcode.June;

public class L3689_Maximum_Total_Subarray_Value_I {
    public static void main(String[] args) {
        int[] nums = {4, 2, 5, 1};
        int k = 3;
        System.out.println(maxTotalValue(nums, k));
    }

    public static long maxTotalValue(int[] nums, int k) {
        long min = Long.MAX_VALUE, max = Long.MIN_VALUE;

        for (int ele : nums) {
            min = Math.min(min, ele);
            max = Math.max(max, ele);
        }

        return k * (max - min);
    }
}
