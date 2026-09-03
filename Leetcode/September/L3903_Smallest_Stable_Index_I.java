package Leetcode.September;

public class L3903_Smallest_Stable_Index_I {
    public static void main(String[] args) {
        int[] nums = {3,2,1};
        int k = 1;
        System.out.println(firstStableIndex(nums, k));
    }

    public static int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] largestArr = largestArr(nums);
        int[] smallestArr = smallestArr(nums);

        for (int i = 0; i < n; i++) {
            if (largestArr[i] -  smallestArr[i] <= k)
                return i;
        }
        return -1;
    }

    private static int[] largestArr(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int curr = nums[0];
        ans[0] = curr;
        for (int i = 1; i < n; i++) {
            curr = Math.max(nums[i], curr);
            ans[i] = curr;
        }
        return ans;
    }

    private static int[] smallestArr(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int curr = nums[n-1];
        ans[n-1] = curr;
        for (int i = n-2; i >= 0; i--) {
            curr = Math.min(nums[i], curr);
            ans[i] = curr;
        }
        return ans;
    }
}
