package Leetcode.May;

public class L1914_Cyclically_Rotating_Grid {
    public static void main(String[] args) {
//[[],[],[],[]], k = 2
        int[][] grid = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};
        int k = 2;
        int[][] rotated = rotateGrid(grid, k);
        for (int[] row : rotated) {
            for (int ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

    public static int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int r1 = 0, r2 = m-1;
        int c1 = 0, c2 = n-1;
        while (r1<r2 && c1<c2) {
            int total = (r2-r1)*2 + (c2-c1)*2;
            int shift = k % total;
            int[] ring = new int[total];
            int index = 0;
            // top
            for (int j = c1; j <c2; j++)
                ring[index++] = grid[r1][j];
            //right
            for (int i=r1; i<r2; i++)
                ring[index++] = grid[i][c2];
            //bottom
            for (int j=c2; j>c1; j--)
                ring[index++] = grid[r2][j];
            //left
            for (int i=r2; i>r1; i--)
                ring[index++] = grid[i][c1];

            //reverse
            reverse(ring, 0, shift-1);
            reverse(ring, shift, total-1);
            reverse(ring, 0, total-1);

            int inx = 0;
            // top
            for (int j = c1; j <c2; j++)
                grid[r1][j] = ring[inx++];
            //right
            for (int i=r1; i<r2; i++)
                grid[i][c2] = ring[inx++];
            //bottom
            for (int j=c2; j>c1; j--)
                grid[r2][j]= ring[inx++];
            //left
            for (int i=r2; i>r1; i--)
                grid[i][c1] = ring[inx++];

            r1++; r2--; c1++; c2--;
        }
        return grid;
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++; end--;
        }
    }
}
