package Leetcode.May;

public class L154_Find_Minimum_in_Rotated_Sorted_Array_II {
    public static void main(String[] args) {
        int[] nums = {5,3,1};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start<end) {
            int mid = start + (end - start)/2;
            if(nums[end] > nums[mid]) {
                end = mid;
            } else if (nums[end] < nums[mid]) {
                start = mid + 1;
            } else {
                end --;
            }
        }
        return nums[start];
    }
}
