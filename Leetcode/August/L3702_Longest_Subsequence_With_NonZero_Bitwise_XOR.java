package Leetcode.August;

public class L3702_Longest_Subsequence_With_NonZero_Bitwise_XOR {
    public static void main(String[] args) {

    }

    public static int longestSubsequence(int[] nums) {
        int xor = 0;
        boolean nonZero = false;

        for (int num : nums) {
            xor ^= num;
            if (num != 0) nonZero = true;
        }
        if (xor != 0) return nums.length;

        return nonZero ? nums.length - 1 : 0;
    }
}