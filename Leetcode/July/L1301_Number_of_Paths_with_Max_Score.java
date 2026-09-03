package Leetcode.July;

import java.util.Arrays;
import java.util.List;

public class L1301_Number_of_Paths_with_Max_Score {
    public static void main(String[] args) {
        List<String> board = List.of("E23", "2X2", "12S");
        int[] ans = pathsWithMaxScore(board);
        System.out.println( Arrays.toString(ans));
    }

    static int[][] path;
    static int[][] sum;
    static int mod =  1000000007;

    public static int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        path = new int[n][n];
        sum = new int[n][n];
        for (int[] arr : path) Arrays.fill(arr, -2);

        int[] result = solve(n-1, n-1, board);

        if (result[0] == -1) return new int[] {0, 0};
        return result;
    }

    private static int[] solve(int row, int col, List<String> board) {
        if (row < 0 || col < 0) return new int[] {-1, 0};

        char ch = board.get(row).charAt(col);
        if (ch == 'X') return new int[] {-1, 0};

        if (row == 0 && col == 0) return new int[] {0, 1};

        if (path[row][col] != -2) return new int[] {sum[row][col], path[row][col]};

        int[] up = solve(row-1, col, board);
        int[] left = solve(row, col-1, board);
        int[] diag = solve(row-1, col-1, board);

        int max = Math.max(up[0], Math.max(left[0], diag[0]));
        if (max == -1) {
            sum[row][col] = -1;
            path[row][col] = 0;
            return new int[] {-1, 0};
        }

        int paths = 0;
        if (up[0] == max) paths = (paths + up[1]) % mod;
        if (left[0] == max) paths = (paths + left[1]) % mod;
        if (diag[0] == max) paths = (paths + diag[1]) % mod;

        int value = (ch == 'S') ? 0 : (ch - '0');
        path[row][col] = paths;
        sum[row][col] = max + value;

        return new int[] {sum[row][col], path[row][col]};
    }
}
