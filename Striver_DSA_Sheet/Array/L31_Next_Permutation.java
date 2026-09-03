package Striver_DSA_Sheet.Array;

public class L31_Next_Permutation {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        nextPermutation(nums);
        for(int ele : nums) System.out.print(ele + " ");
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int number = 0;

        for (int ele : nums) {
            number = number * 10 + ele;
        }


    }
}
