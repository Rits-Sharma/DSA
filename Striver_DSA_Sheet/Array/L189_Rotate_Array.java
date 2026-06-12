package Striver_DSA_Sheet.Array;

public class L189_Rotate_Array {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        int k = 2;
        rotate(nums, k);
        for (int ele : nums) System.out.print(ele + " ");
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        // Reverse the entire array
        reverse(nums, 0, n - 1);
        // Reverse the first k elements
        reverse(nums, 0, k - 1);
        // Reverse the remaining n-k elements
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}