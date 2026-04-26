package Leetcode;

public class L1855_Max_Distance_Between_Values {
    public static void main(String[] args) {
        int[] nums1 = {55,30,5,4,2}, nums2 = {100,20,10,10,5};
        System.out.println(maxDistance(nums1, nums2));
    }

    public static int maxDistance(int[] nums1, int[] nums2) {
        int i =0, j = 0;
        int max = 0;
        while (i < nums1.length && j < nums2.length) {
            if (isValidPair(nums1, nums2, i, j)) {
                max = Math.max(max, j - i);
                j++;
            } else {
                i++;
            }
        }
        return max;
    }

    public static boolean isValidPair(int[] nums1, int[] nums2, int i, int j) {
        return nums1[i] <= nums2[j];
    }
}
