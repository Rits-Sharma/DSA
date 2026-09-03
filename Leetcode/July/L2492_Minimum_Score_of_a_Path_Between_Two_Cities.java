package Leetcode.July;

import java.util.*;

public class L2492_Minimum_Score_of_a_Path_Between_Two_Cities {
    public static void main(String[] args) {
        int n = 4;
        int[][] roads = {{1,2,9}, {2,3,6}, {2,4,5}, {1,4,7}};
        System.out.println(minScore(n, roads));
    }

    public static int minScore(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int weight = road[2];
            adj.get(u).add(new int[]{v, weight});
            adj.get(v).add(new int[]{u, weight}); // Undirected graph है
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        queue.add(1);
        visited[1] = true;

        int minScore = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int[] neighbor : adj.get(node)) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];

                minScore = Math.min(minScore, weight);

                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.add(nextNode);
                }
            }
        }

        return minScore;
    }
}
