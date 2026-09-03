package Leetcode.July;

public class L1979_Find_Greatest_Common_Divisor_of_Array {
    public static void main(String[] args) {
        int[] nums = {2,5,6,9,10};
        System.out.println(findGCD(nums));
    }

    public static int findGCD(int[] nums) {
        int max = nums[0], min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (max > nums[i]) max = nums[i];
            if (min < nums[i]) min = nums[i];
        }
        return gcd(max, min);
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
