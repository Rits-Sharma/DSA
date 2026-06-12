package Striver_DSA_Sheet.Sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1,5,8,-4,-9};
        for (int ele : sort(arr))
            System.out.print(ele + " ");
    }

    public static int[] sort(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            boolean swapped = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return arr;
    }
}
