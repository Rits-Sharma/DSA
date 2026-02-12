package Leetcode;

public class L3379_Transformed_Array {
    public static void main(String[] args) {
        int[] nums = {-1,4,-1};
        int[] result = constructTransformedArray(nums);
        for(int i : result) {
            System.out.print(i + " ");
        }
    }

    public static int[] constructTransformedArray(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int targetIndex = (i + nums[i]) % nums.length;
            if (targetIndex < 0) {
                targetIndex += nums.length;
            }
            result[i] = nums[targetIndex];
        }
        return result;
    }
}
