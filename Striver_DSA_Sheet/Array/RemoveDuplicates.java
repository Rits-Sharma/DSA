package Striver_DSA_Sheet.Array;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicate(nums));
    }

    public static int removeDuplicate(int[] nums) {
        int n =  nums.length;
        if(n==0) return 0;
        // i for slow pointer and j for fast pointer
        int i = 0, j = 1;
        for (j = 1; j < n; j++) {
            if (nums[j]!=nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}
