package Leetcode.June;

import java.util.Arrays;

public class L1846_Maximum_Element_After_Decreasing_and_Rearranging {
    public static void main(String[] args) {
        int[] arr = {2,2,1,2,1};
        System.out.println(maximumEle(arr));
    }

    public static int maximumEle(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);

        // Rule 1: The first element must be 1
        arr[0] = 1;

        // Rule 2: The difference between adjacent elements must be <= 1
        for (int i = 1; i < n; i++) {
            if (arr[i] - arr[i - 1] > 1) {
                arr[i] = arr[i - 1] + 1;
            }
        }

        // Since the array is sorted and monotonically increasing,
        // the largest element is always at the last index.
        return arr[n - 1];
    }
}
