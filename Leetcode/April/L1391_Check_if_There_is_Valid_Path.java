package Leetcode.April;

import java.util.LinkedList;
import java.util.Queue;

public class L1391_Check_if_There_is_Valid_Path {
    public static void main(String[] args) {
        int[][] grid = {{1,2,1}, {1,2,1}};
        System.out.println(hasValidPath(grid));
    }

    private static final int[][][] directions = {{},
            {{0, -1}, {0, 1}},  // Type 1: Left, Right
            {{-1, 0}, {1, 0}},  // Type 2: Up, Down
            {{0, -1}, {1, 0}},  // Type 3: Left, Down
            {{0, 1}, {1, 0}},   // Type 4: Right, Down
            {{0, -1}, {-1, 0}}, // Type 5: Left, Up
            {{0, 1}, {-1, 0}}   // Type 6: Right, Up
    };

    public static boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1];

            if (r == m - 1 && c == n - 1) return true;

            int type = grid[r][c];
            for (int[] dir : directions[type]) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                // 1. Check bounds and if already visited
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                    // 2. Connectivity Check: Does the neighbor pipe point back to the current cell?
                    if (canConnect(nr, nc, r, c, grid[nr][nc])) {
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        return false;
    }

    // Checks if the pipe at (nr, nc) of a specific type can connect back to (targetR, targetC)
    private static boolean canConnect(int nr, int nc, int targetR, int targetC, int neighborType) {
        for (int[] dir : directions[neighborType]) {
            if (nr + dir[0] == targetR && nc + dir[1] == targetC) {
                return true;
            }
        }
        return false;
    }
}
