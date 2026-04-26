package Leetcode;

public class L1848_Minimum_Distance__to_Target_Element {
    public static void main(String[] args) {
        int[] nums = {1,5,3,4,5};
        int target = 5, start = 2;
        System.out.println(minDistance(nums, target, start));
    }

    public static int minDistance(int[] nums, int target, int start) {
        int distance = Integer.MIN_VALUE;
        for (int i = start; i < nums.length; i++) {
            if (nums[i] == target) {
                distance = Math.max(distance, Math.abs(i - start));
                break;
            }
        }
        int distance2 = Integer.MIN_VALUE;
        for (int i = start; i >= 0; i--) {
            if (nums[i] == target) {
                distance2 = Math.max(distance2, Math.abs(i - start));
                break;
            }
        }
        if (distance == Integer.MIN_VALUE) return distance2;
        if (distance2 == Integer.MIN_VALUE) return distance;
        return Math.min(distance, distance2);
    }
}
