package Leetcode.May;

import java.util.HashSet;

public class L3043_Length_of_Longest_Common_Prefix {
    public static void main(String[] args) {
        int[] arr1 = {1, 10, 100}, arr2 = {1000};
        System.out.println(longestCommonPrefix(arr1, arr2));
    }

    public static int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> prefixes = new HashSet<>();
        for (int val : arr1) {
            while (val > 0) {
                prefixes.add(val);
                val /= 10;
            }
        }
        int maxLength = 0;
        for (int val : arr2) {
            while (val > 0) {
                if (prefixes.contains(val)) {
                    maxLength = Math.max(maxLength, String.valueOf(val).length());
                    break;
                }
                val /= 10;
            }
        }
        return maxLength;
    }
}
