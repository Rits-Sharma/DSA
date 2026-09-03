package Leetcode.July;

public class L3513_Number_of_Unique_XOR_Triplets_I {
    public static void main(String[] args) {
        int[] nums = {1,2,4};
        System.out.println(uniqueXorTriplets(nums));
    }

    public static int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        // Base case for small inputs
        if (n < 3) return n;
        // Find the highest bit set in n and shift 1 by (highest_bit_index + 1)
        int highestBit = Integer.highestOneBit(n);
        return highestBit << 1;
    }
}
