package Leetcode;

public class L3655_XOR_After_Range_Multiplication_Queries {
    public static void main(String[] args) {
        L3653_XOR_After_Range_Multiplication_Queries l = new L3653_XOR_After_Range_Multiplication_Queries();
        int[] nums = {1,1,1};
        int[][] queries = {{0,2,1,4}};
        System.out.println(l.xorAfterQueries(nums, queries));
    }

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int MOD = 1_000_000_007;
        // Process each query
        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];
            for (int idx = l; idx <= r; idx += k) {
                long val = ((long) nums[idx] * v) % MOD;
                nums[idx] = (int) val;
            }
        }
        // Compute XOR of all elements
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }

        return ans;
    }
}
