package Leetcode.May;

public class L3300_Minimum_Element_After_Replacement {
    public static void main(String[] args) {
        int[] nums = {999,19,199};
        System.out.println(minElement(nums));
    }

    public static int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int num : nums) {
            int sum = 0;
            while(num > 0) {
                int rem = num % 10;
                sum = sum + rem;
                num = num / 10;
            }
            min = Math.min(sum, min);
        }
        return min;
    }
}
