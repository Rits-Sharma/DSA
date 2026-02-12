package Leetcode;

public class L3637_Trionic_Array {
    public static void main(String[] args) {
        int[] nums = {1,3,5,2,6};
        System.out.println(isTrionic(nums));
    }

    public static boolean isTrionic(int[] nums) {
        if (nums.length < 4) return false;
        boolean flag = false;
        int i = 0;

        while (i + 1 < nums.length && nums[i] < nums[i + 1]) {
            i++;
        }

        int p = i;
        if (p == nums.length -1) return false;
        while (i+1 < nums.length && nums[i] > nums[i + 1]) {
            i++;
        }

        int q = i;
        if (q == nums.length -1) return false;
        while (i+1 < nums.length && nums[i] < nums[i + 1]) {
            i++;
        }
        return (p > 0 && q > 0 && i == nums.length-1);
    }
}
