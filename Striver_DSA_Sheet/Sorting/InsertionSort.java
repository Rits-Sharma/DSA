package Striver_DSA_Sheet.Sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {1,5,8,-4,-9};
        for (int ele : sort(arr))
            System.out.print(ele + " ");
    }

    public static int[] sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i <= n - 1; i++) {
            int j = i;
            while (j > 0 && (arr[j-1] > arr[j])) {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
        return arr;
    }
}
