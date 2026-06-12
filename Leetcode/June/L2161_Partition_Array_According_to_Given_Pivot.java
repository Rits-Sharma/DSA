package Leetcode.June;

import java.util.ArrayList;

public class L2161_Partition_Array_According_to_Given_Pivot {
    public static void main(String[] args) {
        int[] nums = {9,12,5,10,14,3,10};
        int pivot = 10;
        int[] ans = pivotArray2(nums, pivot);
        for (int ele : ans) System.out.print(ele + " ");
    }

    public static int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> small = new ArrayList<>();
        for (int num : nums) {
            if (num < pivot) small.add(num);
        }
        ArrayList<Integer> equal = new ArrayList<>();
        for (int num : nums) {
            if (num == pivot) equal.add(num);
        }
        ArrayList<Integer> large = new ArrayList<>();
        for (int num : nums) {
            if (num > pivot) large.add(num);
        }

        int i = 0, j = 0;
        while (i < small.size()) {
            nums[j] = small.get(i);
            i++; j++;
        }
        i = 0;
        while (i < equal.size()) {
            nums[j] = equal.get(i);
            i++; j++;
        }
        i = 0;
        while (i < large.size()) {
            nums[j] = large.get(i);
            i++; j++;
        }
        return nums;
    }

    public static int[] pivotArray2(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0, right = n-1;

        for (int i = 0, j = n-1; i < n; i++, j--) {
            if (nums[i] < pivot) result[left++] = nums[i];
            if (nums[j] > pivot) result[right--] = nums[j];
        }
        while (left <= right) result[left++] = pivot;
        return result;
    }
}
