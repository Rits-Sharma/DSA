package Leetcode;

import java.util.Arrays;

public class L1984_Min_Diff {
    public static void main(String[] args) {
        int[] nums = {9,4,1,7};
        int minimum = minimumDifference(nums, 3);
        System.out.println(minimum);
    }
    public static int minimumDifference(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int i = 0, j = i + k - 1;
        while(j < nums.length) {
            int minDiff = nums[j] - nums[i];
            if(min > minDiff) min = minDiff;
            i++; j++;
        }
        return min;
    }
}
