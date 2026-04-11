package GFG;

import java.util.Arrays;

public class Missing_Number {
    public static void main(String[] args) {
        int n = 5;
        int[] nums = new int[] {3, 0, 5, 4, 1};
        System.out.println(missingNumber2(nums, n));
    }
/*
    public static int missingNumber(int[] nums, int len) {
        int missing = 0;
        Arrays.sort(nums);
        for (int i = 0; i <= len; i++) {
            if (nums[i] != i) {
                missing = i;
                break;
            }
        }
        return missing;
    }
*/

    public static int missingNumber2(int[] nums, int len) {
        int expectedSum = (len * (len + 1) / 2);
        int actualSum = 0;
        for (int ele : nums) {
            actualSum += ele;
        }
        return expectedSum - actualSum;
    }
}
