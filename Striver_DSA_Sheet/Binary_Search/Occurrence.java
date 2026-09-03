package Striver_DSA_Sheet.Binary_Search;

public class Occurrence {
    public static void main(String[] args) {
        int[] nums = {3, 4, 13, 13, 13, 20, 40};
        int x = 13;
        System.out.println(lastOccurrence(nums, x));
        System.out.println(countOccurrence(nums, x));
    }

    public static int lastOccurrence(int[] nums, int target) {
        int n = nums.length;
        int index = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] == target) index = i;
        }
        return index;
    }

    public static int countOccurrence(int[] nums, int target) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == target) count++;
        }
        return count;
    }
}
