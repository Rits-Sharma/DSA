package Striver_DSA_Sheet.Binary_Search;

public class L35_Search_Insert_Position {
    public static void main(String[] args) {
        int[] nums = {1,2,4,7};
        int x = 2;
        System.out.println(insertPosition(nums, x));
    }

    private static int insertPosition(int[] nums, int target) {
        int left = 0, right = nums.length-1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) return mid;
            else if (nums[ mid] <target) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}
