package Leetcode;

public class L1679_Max_Sum_Pairs {
    public static void main(String[] args) {
        int[] nums = {4,4,1,3,1,3,2,2,5,5,1,5,2,1,2,3,5,4};
        int k = 2;
        System.out.println(maxOperations(nums, k));
    }

    public static int maxOperations(int[] nums, int k) {
        int noOfOperations = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == 0) continue;
                if (nums[i] + nums[j] == k) {
                    nums[i] = 0;
                    nums[j] = 0;
                    noOfOperations++;
                    break;
                }
            }
        }
        return noOfOperations;
    }
}
