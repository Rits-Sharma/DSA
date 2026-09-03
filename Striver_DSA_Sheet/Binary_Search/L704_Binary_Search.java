package Striver_DSA_Sheet.Binary_Search;

public class L704_Binary_Search {
    public static void main(String[] args) {
        int[] nums = {2,5};
        int target = 5;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + high / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }

        return -1;
    }
}
