package Leetcode.May;

import java.util.ArrayList;
import java.util.Collections;

public class L2553_Separate_Digits {
    public static void main(String[] args) {
        int[] nums = {13,25,83,77};
        int[] ans = separateDigits(nums);
        for (int ele : ans) {
            System.out.print(ele + " ");
        }
    }

    public static int[] separateDigits(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        for (int ele : nums) {
            while (ele != 0) {
                int curr = ele % 10;
                current.add(curr);
                ele /= 10;
            }
            Collections.reverse(current);
            list.addAll(current);
            current.clear();
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
