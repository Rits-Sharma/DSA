package Leetcode.June;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class L3286_Find_a_Safe_Walk_Through_Grid {
    public static void main(String[] args) {
        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(0,1,1,0,0,0),
                Arrays.asList(1,0,1,0,0,0),
                Arrays.asList(0,1,1,1,0,1),
                Arrays.asList(0,0,1,0,1,0)
        );
        int health = 3;

        System.out.println(findSafeWalk(grid, health));
    }

    static int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};

    public static boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size(), n = grid.getFirst().size();

        int[][] mat = grid.stream()
                .map(inner->inner.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        pq.offer(new int[]{mat[0][0],0,0});
        mat[0][0] = Integer.MAX_VALUE;

        while (!pq.isEmpty()) {
            int[] curr = pq.remove();
            int cost = curr[0], x = curr[1], y = curr[2];

            if (x == m-1 && y == n-1) return true;

            for (int[] d : dir) {
                int r = x + d[0];
                int c = y + d[1];
                if(r<0 || r>=m || c<0 || c>=n || health-mat[r][c]<=0)
                    continue;
                int nextCost = cost + mat[r][c];
                if(nextCost < health)
                    pq.offer(new int[]{nextCost, r, c});
                mat[r][c] = Integer.MAX_VALUE;
            }
        }

        return false;
    }
}
