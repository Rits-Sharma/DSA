package Leetcode.August;

import java.util.ArrayList;
import java.util.List;

public class L3310_Remove_Methods_From_Project {
    public static void main(String[] args) {
        int n = 4, k = 1;
        int[][] invocations = {{1,2}, {0,1}, {3,2}};
        List<Integer> ans = remainingMethods(n, k, invocations);
        System.out.println(ans);
    }

    public static List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : invocations) {
            graph[edge[0]].add(edge[1]);
        }

        boolean[] suspicious = new boolean[n];

        // Step 1: Mark all methods reachable from k as suspicious
        dfs(k, graph, suspicious);

        // Step 2: Check if any non-suspicious method invokes a suspicious method
        boolean isValidToRemove = true;
        for (int[] edge : invocations) {
            int u = edge[0];
            int v = edge[1];

            if (!suspicious[u] && suspicious[v]) {
                isValidToRemove = false;
                break;
            }
        }

        // Step 3: Prepare the final list of remaining methods
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (isValidToRemove) {
                if (!suspicious[i]) {
                    ans.add(i);
                }
            } else {
                ans.add(i); // If we cannot remove suspicious methods, return all methods
            }
        }

        return ans;
    }

    public static void dfs(int node, List<Integer>[] graph, boolean[] suspicious) {
        suspicious[node] = true;

        for (int next : graph[node]) {
            if (!suspicious[next]) {
                dfs(next, graph, suspicious);
            }
        }
    }
}
