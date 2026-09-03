package Leetcode.August;

import java.util.ArrayList;

public class L3069_Distribute_Elements {
    public static void main(String[] args) {

    }

    public static int[] resultArray(int[] nums) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        int[] result = new int[nums.length];

        arr1.add(nums[0]);
        arr2.add(nums[1]);

        for (int i = 2; i < nums.length; i++) {
            if (arr1.getLast() > arr2.getLast()) arr1.add(nums[i]);
            else arr2.add(nums[i]);
        }

        for (int i = 0; i < arr1.size(); i++)
            result[i] = arr1.get(i);
        for (int i = arr1.size(); i < arr1.size()+arr2.size(); i++)
            result[i] = arr2.get(i-arr1.size());

        return result;
    }
}
