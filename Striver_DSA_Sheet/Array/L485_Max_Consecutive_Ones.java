package Striver_DSA_Sheet.Array;

public class L485_Max_Consecutive_Ones {
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        System.out.println(maxOnes(nums));
    }

    public static int maxOnes(int[] nums) {
        int curr = 0, max = 0;

        for (int ele : nums) {
            if (ele == 1) curr++;
            max = Math.max(max, curr);
            if (ele != 1) curr = 0;
        }
        return max;
    }
}
