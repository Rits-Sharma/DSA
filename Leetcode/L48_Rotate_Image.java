package Leetcode;

public class L48_Rotate_Image {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] ans = rotate(matrix);
        for (int[] an : ans) {
            for (int j = 0; j < ans.length; j++) {
                System.out.print(an[j]);
            }
            System.out.println();
        }
    }

    public static int[][] rotate(int[][] matrix) {
        int n = matrix.length;
        int m = n;
        int[][] ans = new int[m][m];

        for (int[] ints : matrix) {
            for (int j = 0; j < n; j++) {
                ans[j][m - 1] = ints[j];
            }
            m--;
        }
        return ans;
    }
}
