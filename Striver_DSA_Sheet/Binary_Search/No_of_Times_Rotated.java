package Striver_DSA_Sheet.Binary_Search;

public class No_of_Times_Rotated {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2,3};
        System.out.println(timesRotated(nums));
    }

    private static int timesRotated(int[] nums) {
        int index = 0;
        int n = nums.length;

        for (int i = 0; i < n-1; i++) {
            if (nums[i] > nums[i+1]) {index = i;}
        }

        return index+1;
    }
}
