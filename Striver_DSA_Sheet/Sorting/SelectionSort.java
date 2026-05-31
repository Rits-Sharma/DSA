package Striver_DSA_Sheet.Sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {1,5,8,4,-9};
        for (int ele : sort(arr))
            System.out.print(ele + " ");
    }

    private static int[] sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}
