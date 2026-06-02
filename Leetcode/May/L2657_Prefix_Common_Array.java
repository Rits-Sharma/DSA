package Leetcode.May;

public class L2657_Prefix_Common_Array {
    public static void main(String[] args) {
        int[] A = {1,3,2,4}, B = {3,1,2,4};
        int[] ans = findThePrefixCommonArray(A, B);
        for (int ele : ans) System.out.print(ele + " ");
    }

    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] C = new int[n];
        // seen array to track frequencies. Size is n + 1 because the numbers are 1-indexed (1 to n)
        // In Java, primitive integer arrays are automatically initialized to 0.
        int[] seen = new int[n + 1];
        int commonCount = 0;

        for (int i = 0; i < n; i++) {
            // Process element from A
            seen[A[i]]++;
            if (seen[A[i]] == 2) {
                commonCount++;
            }
            // Process element from B
            seen[B[i]]++;
            if (seen[B[i]] == 2) {
                commonCount++;
            }
            // Record the common count at the current prefix
            C[i] = commonCount;
        }
        return C;
    }
}
