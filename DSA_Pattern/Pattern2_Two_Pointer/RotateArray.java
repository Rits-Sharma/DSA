package DSA_Pattern.Pattern2_Two_Pointer;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int[] revArray = rotate(nums, 1);
        for (int ele : revArray) {
            System.out.print(ele + " ");
        }
    }
    public static int[] rotate(int[] arr, int k) {
        reverse(arr, 0, arr.length-1);
        reverse(arr, 0, k -1);
        reverse(arr, k, arr.length-1);
        return arr;
    }

    public static void reverse(int[] arr, int start, int end) {
        int i = start, j = end;
        while(i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; j--;
        }
    }
}
