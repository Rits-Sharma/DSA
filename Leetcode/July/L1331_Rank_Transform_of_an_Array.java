package Leetcode.July;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L1331_Rank_Transform_of_an_Array {
    public static void main(String[] args) {
        int[] arr = {37,12,28,9,100,56,80};
        int[] ans = arrayRankTransform(arr);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] arrayRankTransform(int[] arr) {
        int[] arrCopy = arr.clone();
        Arrays.sort(arrCopy);

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (int ele : arrCopy) {
            if (!(map.containsKey(ele))) map.put(ele, rank++);
        }

        for (int i = 0; i < arr.length; i++) arr[i] = map.get(arr[i]);

        return arr;
    }
}
