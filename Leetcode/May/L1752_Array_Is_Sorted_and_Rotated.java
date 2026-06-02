package Leetcode.May;

public class L1752_Array_Is_Sorted_and_Rotated {
    public static void main(String[] args) {
        int[] nums ={3,4,5,1,2};
        System.out.println(check(nums));
    }

    public static boolean check(int[] nums) {
        int n = nums.length;
        int drops = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) drops++;
        }
        return drops <= 1;
    }
}
