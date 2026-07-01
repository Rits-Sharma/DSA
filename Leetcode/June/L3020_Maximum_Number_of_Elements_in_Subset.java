package Leetcode.June;

import java.util.HashMap;
import java.util.Map;

public class L3020_Maximum_Number_of_Elements_in_Subset {
    public static void main(String[] args) {
        int[] nums = {5,4,1,2,2};
        System.out.println(maximumLength(nums));
    }

    public static int maximumLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int maxLen = 1;
        if (map.containsKey(1)) {
            int countOfOnes = map.get(1);
            maxLen = Math.max(maxLen, countOfOnes % 2 == 0 ? countOfOnes - 1 : countOfOnes);
            map.remove(1);
        }
        for (int key : map.keySet()) {
            long curr = key;
            int len = 0;
            while (curr <= 1_000_000_000 && map.getOrDefault((int) curr, 0) >= 2) {
                len += 2;
                curr = curr * curr;
            }
            if (curr <= 1_000_000_000 && map.getOrDefault((int) curr, 0) >= 1) {
                len += 1;
            } else {
                len -= 1;
            }

            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
}
