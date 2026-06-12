package Striver_DSA_Sheet.Array;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class GFG_Union_Of_Two_Numbers {
    public static void main(String[] args) {
        int n = 10,m = 7;
        int[] arr1 = {1,2,3,4,5,6,7,8,9,10}, arr2 = {2, 3, 4, 4, 5, 11, 12};
        List<Integer> union = findUnion(arr1, arr2, n, m);

        for (int val : union)
            System.out.print(val + " ");
    }

    private static List<Integer> findUnion(int[] arr1, int[] arr2, int n, int m) {
        TreeMap<Integer, Integer> freq = new TreeMap<>();

        for (int i = 0; i < n; i++)
            freq.put(arr1[i], freq.getOrDefault(arr1[i], 0) + 1);

        for (int i = 0; i < m; i++)
            freq.put(arr2[i], freq.getOrDefault(arr2[i], 0) + 1);

        return new ArrayList<>(freq.keySet());
    }
}
