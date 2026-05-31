package Leetcode;

public class L1306_Jump_Game_III {
    public static void main(String[] args) {
        int[] nums = {4,2,3,0,3,1,2};
        int start = 0;
        System.out.println(canReach(nums, start));
    }

    public static boolean canReach(int[] arr, int start) {
        // Base case: If we jump out of bounds, or reach an already visited index
        if (start < 0 || start >= arr.length || arr[start] < 0) {
            return false;
        }

        // If we reach our target, return true
        if (arr[start] == 0) {
            return true;
        }

        // Store the jump distance and mark the current index as visited
        int jump = arr[start];
        arr[start] = -arr[start];

        // Recursively try jumping right and jumping left
        return canReach(arr, start + jump) || canReach(arr, start - jump);
    }
}
