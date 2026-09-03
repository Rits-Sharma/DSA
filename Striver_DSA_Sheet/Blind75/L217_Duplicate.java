package Striver_DSA_Sheet.Blind75;

import java.util.HashSet;
import java.util.Set;

public class L217_Duplicate {
    public static void main(String[] args) {

    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (!seen.add(num)) {
                return true;
            }
        }

        return false;
    }
}
