package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class L3741_Minimum_Distance {
    public static void main(String[] args) {
        int[] nums = {1,2,1,1,3};
        System.out.println(minimumDistance(nums));
    }

    public static int minimumDistance(int[] nums) {
        int n = nums.length;
        int ans = n + 1;
        
        Map<Integer, int[]> lastTwoIndices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int val = nums[i];
            if (!lastTwoIndices.containsKey(val)) {
                lastTwoIndices.put(val, new int[]{-1, i});
            } else {
                int[] indices = lastTwoIndices.get(val);
                if (indices[0] != -1) {
                    ans = Math.min(ans, i - indices[0]);
                }
                indices[0] = indices[1];
                indices[1] = i;
            }
        }
        return ans == n + 1 ? -1 : ans * 2;
    }
}
