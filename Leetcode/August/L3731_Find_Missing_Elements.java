package Leetcode.August;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L3731_Find_Missing_Elements {
    public static void main(String[] args) {
        int[] nums = {1, 5};
        List<Integer> missing = findMissingElements(nums);
        System.out.println(missing);
    }

    public static List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length - 1; i++) {
            int current = nums[i];
            int next = nums[i + 1];

            for (int val = current + 1; val < next; val++) {
                ans.add(val);
            }
        }

        return ans;
    }
}
