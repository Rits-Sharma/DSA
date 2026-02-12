package Leetcode;

public class FindMaxConsecutive {
    public static void main(String[] args) {
        int[] nums = {1,0,1,1,0,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int curr = 0;
        int max = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == 1) {
                curr++;
                if (nums[i+1] == 0) {
                    curr = 0;
                }
                if (curr > max) max = curr;
            }
        }
        return max;
    }
}
