package Leetcode.July;

import java.util.*;

public class L3620_Network_Recovery_Pathways {
    public static void main(String[] args) {

    }

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;

        // 1. Build the adjacency list and calculate in-degrees for topological sort
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] inDegree = new int[n];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            graph[u].add(new int[]{v, cost});
            inDegree[v]++;
        }

        // 2. Compute a global topological order
        int[] topoOrder = new int[n];
        int index = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();
            topoOrder[index++] = u;
            for (int[] edge : graph[u]) {
                int v = edge[0];
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        // 3. Binary Search for the maximum valid minimum-edge cost
        int low = 0, high = 1_000_000_000;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(mid, n, graph, topoOrder, online, k)) {
                ans = mid;         // mid is feasible, try to find a larger minimum edge cost
                low = mid + 1;
            } else {
                high = mid - 1;    // mid is too large, reduce the threshold
            }
        }

        return ans;
    }

    private boolean check(int mid, int n, List<int[]>[] graph, int[] topoOrder, boolean[] online, long k) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        // Process nodes in the pre-calculated valid topological order
        for (int u : topoOrder) {
            if (dist[u] == Long.MAX_VALUE) {
                continue; // Skip unreachable nodes
            }

            for (int[] edge : graph[u]) {
                int v = edge[0];
                int cost = edge[1];

                // Filter out edges below our binary search threshold
                if (cost < mid) {
                    continue;
                }
                // Filter out destination nodes that are offline (except the target node n-1)
                if (v != n - 1 && !online[v]) {
                    continue;
                }

                // Relax the edge safely avoiding long overflow
                if (dist[u] + cost < dist[v]) {
                    dist[v] = dist[u] + cost;
                }
            }
        }

        return dist[n - 1] <= k;
    }
}