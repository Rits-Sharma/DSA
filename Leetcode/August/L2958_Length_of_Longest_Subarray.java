package Leetcode.August;

import java.util.HashMap;

public class L2958_Length_of_Longest_Subarray {
    public static void main(String[] args) {
        int[] nums = {2,2,3};
        int k = 1;
        System.out.println(maxSubArrayLength(nums, k));
    }

    public static int maxSubArrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {
            int num = nums[right];
            map.put(num, map.getOrDefault(num, 0) + 1);
            while (map.get(num) > k) {
                int leftNum = nums[left];
                map.put(leftNum, map.get(leftNum) - 1);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
