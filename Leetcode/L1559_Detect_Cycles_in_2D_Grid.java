package Leetcode;

public class L1559_Detect_Cycles_in_2D_Grid {
    public static void main(String[] args) {
        char[][] grid = {{'a','a','a','a'}, {'a','b','b','a'}, {'a','b','b','a'}, {'a','a','a','a'}};
        System.out.println(containsCycle(grid));
    }

    public static boolean containsCycle(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j]) {
                    // Start DFS. If it returns true, a cycle exists.
                    if (dfs(grid, visited, i, j, -1, -1, grid[i][j])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] grid, boolean[][] visited, int r, int c, int pr, int pc, char charToMatch) {
        visited[r][c] = true;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == charToMatch) {
                if (visited[nr][nc]) {
                    // If it's visited and NOT the parent, it's a cycle!
                    if (nr != pr || nc != pc) return true;
                } else {
                    if (dfs(grid, visited, nr, nc, r, c, charToMatch)) return true;
                }
            }
        }
        return false;
    }
}
