package Leetcode.July;

import java.util.ArrayList;
import java.util.List;

public class L1260_Shift_2D_Grid {
    public static void main(String[] args) {
        int[][] grid = {{1,2,3}, {4,5,6}, {7,8,9}};
        int k = 1;
        List<List<Integer>> shiftedGrid = shiftGrid(grid, k);
        System.out.println(shiftedGrid);
    }

    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m =  grid.length;
        int n = grid[0].length;

        int[] arr = new int[m*n];
        int curr = 0;

        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                arr[curr++] = ints[j];
            }
        }

        shift(arr, k);
        curr = 0;

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(arr[curr++]);
            }
            res.add(list);
        }

        return res;
    }

    public static void shift(int[] nums, int k) {
        int n = nums.length;

        for (int i = 0; i < k; i++) {
            int last = nums[n-1];
            for (int j = 1; j < n; j++) {
                nums[n- j] = nums[n- j -1];
            }
            nums[0] = last;
        }
    }
}
