package Striver_DSA_Sheet.Array;

import java.util.Arrays;

public class Missing_Number {
    public static void main(String[] args) {
        int[] arr = {8, 2, 4, 5, 3, 7, 1};
        System.out.println(missingNum(arr));
    }

    private static int missingNum(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        for (int i = 1; i <= n; i++) if (arr[i-1] != i) return i;
        return -1;
    }
}
