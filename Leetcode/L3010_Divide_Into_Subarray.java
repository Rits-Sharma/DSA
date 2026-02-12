package Leetcode;

public class L3010_Divide_Into_Subarray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,12};
//        System.out.println(nums.length);
        System.out.println(minimumCost(nums));
    }

    public static int minimumCost(int[] nums) {
        int cost = nums[0];
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < first) {
                second = first;
                first = nums[i];
            }
            else if (nums[i] < second) second = nums[i];
        }
        cost += first + second;
        return cost;
    }
}
