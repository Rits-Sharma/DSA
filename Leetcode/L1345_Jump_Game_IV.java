package Leetcode;

import java.util.*;

public class L1345_Jump_Game_IV {
    public static void main(String[] args) {
        int[] arr = {100,-23,-23,404,100,23,23,23,3,404};
        System.out.println(minJumps(arr));
    }

    public static int minJumps(int[] arr) {
        int n = arr.length;

        // Base case: If the array has 1 or fewer elements, 0 steps are needed.
        if (n <= 1) {
            return 0;
        }

        // Map to store the list of indices for each unique value in the array
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        // Queue for BFS storing the indices
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        // Visited array to prevent infinite loops and redundant checks
        boolean[] visited = new boolean[n];
        visited[0] = true;

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            // Process all nodes at the current BFS level
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                // If we've reached the last index, return the current step count
                if (curr == n - 1) {
                    return steps;
                }

                // 1. Jump to other indices with the same value
                List<Integer> neighbors = graph.get(arr[curr]);
                if (neighbors != null) {
                    for (int next : neighbors) {
                        if (!visited[next]) {
                            visited[next] = true;
                            queue.offer(next);
                        }
                    }
                    // CRUCIAL: Remove the value from the map after visiting
                    // to prevent redundant processing and TLE.
                    graph.remove(arr[curr]);
                }

                // 2. Jump forward (curr + 1)
                if (curr + 1 < n && !visited[curr + 1]) {
                    visited[curr + 1] = true;
                    queue.offer(curr + 1);
                }

                // 3. Jump backward (curr - 1)
                if (curr - 1 >= 0 && !visited[curr - 1]) {
                    visited[curr - 1] = true;
                    queue.offer(curr - 1);
                }
            }
            // Increment step counter after finishing the current level
            steps++;
        }

        return -1; // Should not reach here based on problem constraints
    }
}
