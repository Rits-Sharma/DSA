package Striver_DSA_Sheet.Array;

import java.util.HashMap;
import java.util.Map;

public class L169_Majority_Element {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1};
        System.out.println(majorityElement(nums));
    }

    private static int majorityElement(int[] nums) {
        int ans = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int ele : nums) {
            if (map.containsKey(ele)) map.put(ele, map.get(ele) + 1);
            else map.put(ele, 1);
        }

        int maxValue = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                ans = entry.getKey();
            }
        }

        return ans;
    }
}
