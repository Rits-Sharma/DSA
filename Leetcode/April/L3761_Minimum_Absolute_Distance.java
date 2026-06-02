package Leetcode.April;

import java.util.HashMap;
import java.util.Map;

public class L3761_Minimum_Absolute_Distance {
    public static void main(String[] args) {
        int[] nums = {12,21,45,33,54};
        System.out.println(minMirrorPairDistance(nums));
    }

    public static int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> pos = new HashMap<>(n);
        int ans = n + 1;
        for (int i = 0; i < n; ++i) {
            if (pos.containsKey(nums[i])) {
                ans = Math.min(ans, i - pos.get(nums[i]));
            }
            pos.put(reverse(nums[i]), i);
        }
        return ans > n ? -1 : ans;
    }

    private static int reverse(int x) {
        int y = 0;
        for (; x > 0; x /= 10) {
            y = y * 10 + x % 10;
        }
        return y;
    }
}
