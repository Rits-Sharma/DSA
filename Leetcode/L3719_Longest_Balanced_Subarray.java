package Leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class L3719_Longest_Balanced_Subarray {
    public static void main(String[] args) {
        int[] nums = {2,2,2,2,3,4,6,8,5};
        System.out.println(longestBalanced(nums));
    }

    public static int longestBalanced(int[] nums) {
        Set<Integer> evenSet = new HashSet<>();
        Set<Integer> oddSet = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : nums) {
            if (a % 2 == 0) {
                evenSet.add(a);
            } else {
                oddSet.add(a);
            }
            if (map.containsKey(a)) {
                int currCount = map.get(a);
                map.put(a, currCount + 1);
            } else {
                map.put(a,1);
            }
        }
        if (evenSet.isEmpty() || oddSet.isEmpty()) {
            return 0;
        }
            int mainCount = 0;
        if (evenSet.size() > oddSet.size()) {
            // even dominate
            // follow odd
            int oddSize = oddSet.size();
            for (int s : oddSet) {
                mainCount += map.get(s);
            }
            List<Integer> evenValueSorted = map
                    .keySet()
                    .stream()
                    .filter(key -> key % 2 == 0)
                    .sorted((a,b) -> map.get(b) - map.get(a))
                    .collect(Collectors.toList());
            for (int i=0;i<oddSet.size();i++) {
                mainCount += map.get(evenValueSorted.get(i));
            }
        } else {
            // odd dominate
            // follow even
            int evenSize = evenSet.size();
            for (int s : evenSet) {
                mainCount += map.get(s);
            }
            List<Integer> oddValueSorted = map.keySet().stream().filter(key -> key % 2 != 0)
                    .sorted((a,b) -> map.get(b) - map.get(a))
                    .collect(Collectors.toList());
            for (int i=0;i<evenSet.size();i++) {
                mainCount += map.get(oddValueSorted.get(i));
            }
        }
return  mainCount;
    }

}
