package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L2615_Sum_of_Distances {
    public static void main(String[] args) {
        int[] nums = {1,3,1,1,2};
        long[] ans = distance(nums);
        for (long ele : ans) {
            System.out.print(ele + " ");
        }
    }
    public static long[] distance(int[] nums) {
        int n = nums.length;
        long[] res = new long[n];

        // Map each value to its list of indices
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        // Process each group of indices
        for (List<Integer> indices : map.values()) {
            int m = indices.size();
            long[] prefix = new long[m + 1];

            // Build prefix sums of indices
            for (int i = 0; i < m; i++) {
                prefix[i + 1] = prefix[i] + indices.get(i);
            }

            // Compute result for each index
            for (int i = 0; i < m; i++) {
                int idx = indices.get(i);
                long left = (long) i * indices.get(i) - prefix[i];
                long right = (prefix[m] - prefix[i + 1]) - (long)(m - i - 1) * indices.get(i);
                res[idx] = left + right;
            }
        }

        return res;
    }

}
