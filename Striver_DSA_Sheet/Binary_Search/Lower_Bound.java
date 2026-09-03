package Striver_DSA_Sheet.Binary_Search;

public class Lower_Bound {
    public static void main(String[] args) {
        int[] arr = {3,5,8,15,19};
        int x = 9;
        System.out.println(lower(arr, x));

    }

    public static int lower(int[] nums, int x) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] >= x) return i;
        }

        return -1;
    }
}
