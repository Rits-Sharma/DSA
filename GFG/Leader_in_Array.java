package GFG;

import java.util.ArrayList;
import java.util.Scanner;

public class Leader_in_Array {
    public static void main(String[] args) {
        int n;
        int[] nums;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of elements in the array: ");
        n=sc.nextInt();
        nums=new int[n];
        System.out.println("Enter the elements in the array: ");
        for(int i=0;i<n;i++) nums[i]=sc.nextInt();
        int[] result = leaders(nums, n);
        System.out.println("The leaders of the array is: ");
        for (int l : result) System.out.print(l + " ");
    }

    public static int[] leaders(int[] nums, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        int max_Last = nums[k - 1];
        for (int i = k-1; i > -1; i--) {
            if (max_Last <= nums[i]) {
                max_Last = nums[i];
                ans.add(nums[i]);
            }
        }
        int[] res = new int[ans.size()];
        for (int i = ans.size()-1; i >= 0; i--) {
            res[i] = ans.get(i);
        }
        return res;
    }
}
