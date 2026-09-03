package Leetcode.July;

import java.util.Arrays;

public class L3867_Sum_of_GCD_of_Formed_Pairs {
    public static void main(String[] args) {
        int[] nums = {2,6,4};
        System.out.println(gcdSum(nums));
    }

    public static long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixMax = new int[n];
        int[] prefixGCD = new int[n];

        int max = nums[0];
        for (int i = 0; i < n; i++) {
            if (nums[i] > max) {
                prefixMax[i] = nums[i];
                max = nums[i];
            }
            else prefixMax[i] = max;

            prefixGCD[i] = gcd(nums[i], prefixMax[i]);
        }

        Arrays.sort(prefixGCD);

        long sum = 0;
        int low = 0, high = n-1;
        while (low < high) {
            sum += gcd(prefixGCD[low], prefixGCD[high]);
            low++; high--;
        }

        return sum;
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
