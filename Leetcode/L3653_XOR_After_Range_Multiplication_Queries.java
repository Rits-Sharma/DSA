package Leetcode;

public class L3653_XOR_After_Range_Multiplication_Queries {
    public static void main(String[] args) {
        L3653_XOR_After_Range_Multiplication_Queries l = new L3653_XOR_After_Range_Multiplication_Queries();
        int[] nums = {1,1,1};
        int[][]queries = {{0,2,1,4}};
        System.out.println(l.xorAfterQueries(nums, queries));
    }

    public int xorAfterQueries(int[] nums, int[][] queries) {
        final int mod = (int) 1e9 + 7;
        for (var q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];
            for (int idx = l; idx <= r; idx += k) {
                nums[idx] = (int) ((long) nums[idx] * v % mod);
            }
        }
        int ans = 0;
        for (int x : nums) {
            ans ^= x;
        }
        return ans;
    }
}
