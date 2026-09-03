package Leetcode.June;

import java.util.ArrayDeque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class L2812_Find_Safest_Path_in_a_Grid {
    public static void main(String[] args) {

    }

    static int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public static int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();

        Queue<int[]> q = new ArrayDeque<>();
        int[][] mat = new int[n][n];

        // Collect all thief cells as BFS sources
        // Time: O(n^2), Space: O(n^2)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid.get(i).get(j);
                mat[i][j] = val;
                if (val == 1) q.offer(new int[]{i, j});
            }
        }

        // Multi-source BFS: compute min distance to nearest thief for every cell
        while (!q.isEmpty()) {
            int[] curr = q.remove();
            int x = curr[0], y = curr[1];
            for (int i = 0; i < 4; i++) {
                int r = x + dir[i][0];
                int c = y + dir[i][1];
                if (r < 0 || r >= n || c < 0 || c >= n || mat[r][c] > 0) continue;
                mat[r][c] = mat[x][y] + 1;
                q.offer(new int[]{r, c});
            }
        }

        // Dijkstra: max-heap on safeness — find path from (0,0) to (n-1,n-1)
        // that maximises the minimum safeness along the way
        // Time: O(n^2 log n^2)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        pq.offer(new int[]{mat[0][0], 0, 0});
        mat[0][0] = -1; // Mark as visited

        while (!pq.isEmpty()) {
            int[] curr = pq.remove();
            int sfac = curr[0], x = curr[1], y = curr[2];

            if (x == n - 1 && y == n - 1) return sfac - 1;

            for (int i = 0; i < 4; i++) {
                int r = x + dir[i][0];
                int c = y + dir[i][1];
                if (r < 0 || r >= n || c < 0 || c >= n || mat[r][c] < 0) continue;
                // Bottleneck: carry forward the minimum safeness on this path
                int min = Math.min(sfac, mat[r][c]);
                pq.offer(new int[]{min, r, c});
                mat[r][c] = -1; // Mark as visited
            }
        }

        return 0;
    }
}
