package Striver_DSA_Sheet.Array;

public class L2149_Rearrange_Array_Elements_by_Sign {
    public static void main(String[] args) {
        int[] nums = {3,1,-2,-5,2,-4};
        int[] ans = rearrangeArray(nums);
        for(int ele : ans) System.out.print(ele + " ");
    }

    public static int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] tempPos = new int[n/2];
        int[] tempNeg = new int[n/2];
        int pos = 0, neg = 0;


        for (int num : nums) {
            if (num >= 0) tempPos[pos++] = num;
            else tempNeg[neg++] = num;
        }
        pos = 0;
        neg = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) nums[i] = tempPos[pos++];
            else nums[i] = tempNeg[neg++];
        }

        return nums;
    }
}
