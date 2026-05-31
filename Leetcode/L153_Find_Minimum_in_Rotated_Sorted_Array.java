package Leetcode;

public class L153_Find_Minimum_in_Rotated_Sorted_Array {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int min = nums[0];
        for (int ele : nums)
            min = Math.min(min, ele);
        return min;
    }
}
