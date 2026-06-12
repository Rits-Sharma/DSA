package Striver_DSA_Sheet.Array;

import java.util.Arrays;

public class SecondLargest {
    public static void main(String[] args) {
        int[] arr = {1,15,8,-4,-9};
        System.out.println(secLargest2(arr));
    }

    public static int secLargest(int[] arr) {
        int n = arr.length;
        int lar = Integer.MIN_VALUE;
        int secLar = Integer.MIN_VALUE;

        for (int j : arr) {
            if (lar < j) {
                secLar = lar;
                lar = j;
            } else if (lar > j && j > secLar) {
                secLar = j;
            }
        }
        return secLar;
    }

    public static int secLargest2(int[] arr) {
        Arrays.sort(arr);
        if (arr.length >= 2) return arr[arr.length - 2];
        return arr[0];
    }
}
