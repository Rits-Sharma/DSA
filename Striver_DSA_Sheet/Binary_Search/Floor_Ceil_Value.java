package Striver_DSA_Sheet.Binary_Search;

public class Floor_Ceil_Value {
    public static void main(String[] args) {
        int[] arr = {3, 4, 4, 7, 8, 10};
        int x= 5;
        System.out.println(floorCeilValue(arr, x)[0] + " " + floorCeilValue(arr, x)[1]);
    }

    private static int[] floorCeilValue(int[] arr, int x) {
        int n = arr.length;
        int left = 0, right = n-1;
        int floor = arr[0], ceil = arr[n-1];

        while (left < right) {
            if (arr[left] <= x) floor = arr[left];
            if (arr[right] >= x) ceil = arr[right];
            left++; right--;
        }

        return new int[]{floor, ceil};
    }


}
