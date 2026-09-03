package Leetcode.August;

import java.util.HashSet;
import java.util.Set;

public class L2996_Smallest_Missing_Integer {
    public static void main(String[] args) {
        int[] nums = {29,30,31,32,33,34,35,36,37};
        System.out.println(missingInteger(nums));
    }

    public static int missingInteger(int[] nums) {
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }

        Set<Integer> set = new HashSet<>();
        for(int num : nums)
            set.add(num);

        while(set.contains(sum))
            sum++;

        return sum;
    }
}
