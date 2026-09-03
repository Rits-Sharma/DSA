package Leetcode.July;

public class L3514_Number_of_Unique_XOR_Triplets_II {
    public static void main(String[] args) {
        int[] nums = {1,2,4};
        System.out.println(uniqueXorTriplets(nums));
    }

    public static int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        // Find the maximum value in nums to determine bit range
        int maxEl = 0;
        for (int num : nums) {
            maxEl = Math.max(maxEl, num);
        }

        // Find the upper bound limit T (smallest power of 2 > maxEl)
        int T = 1;
        while (T <= maxEl) {
            T <<= 1;
        }

        // s1[x] will be true if x can be formed by XOR of 2 elements
        boolean[] s1 = new boolean[T];
        // s2[x] will be true if x can be formed by XOR of 3 elements
        boolean[] s2 = new boolean[T];

        // Step 1: Record all possible XOR values of two elements
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                s1[nums[i] ^ nums[j]] = true;
            }
        }

        // Step 2: Combine pair XORs with a 3rd element
        for (int xorPair = 0; xorPair < T; xorPair++) {
            if (s1[xorPair]) {
                for (int num : nums) {
                    s2[xorPair ^ num] = true;
                }
            }
        }

        // Step 3: Count total unique triplet XOR values
        int count = 0;
        for (int i = 0; i < T; i++) {
            if (s2[i]) {
                count++;
            }
        }

        return count;
    }
}
