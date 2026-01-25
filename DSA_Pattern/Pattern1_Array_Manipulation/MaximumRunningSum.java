package DSA_Pattern.Pattern1_Array_Manipulation;

public class MaximumRunningSum {
    public static void main(String[] args) {
        int[] nums = {3,-5,7,-1};
        System.out.println("Maximum running sum position: " + maxSumPosition(nums));
    }

    public static int maxSumPosition(int[] nums) {
        int sum = 0, pos = -1, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(max < sum) {
                max = sum;
                pos = i;
            }
        }
        return pos;
    }
}
