package Striver_DSA_Sheet.Array;

public class Longest_Subarray_With_Given_Sum {
    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 7, 1, 9};
        int k = 15;
        System.out.println(longestSubArray(nums, k));
    }

    public static int longestSubArray(int[] nums, int k) {
        int n = nums.length;
        int maxLength = 0;

        for (int startIndex = 0; startIndex < n; startIndex++) {
            for (int endIndex = startIndex; endIndex < n; endIndex++) {
                int currentSum = 0;
                for (int i = startIndex; i <= endIndex; i++) {
                    currentSum += nums[i];
                }
                if (currentSum == k) maxLength = Math.max(maxLength, endIndex-startIndex+1);
            }
        }
        return maxLength;
    }
}
