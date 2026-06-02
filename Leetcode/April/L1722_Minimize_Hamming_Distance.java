package Leetcode.April;

import java.util.HashMap;
import java.util.Map;

public class L1722_Minimize_Hamming_Distance {
    public static void main(String[] args) {
        int[] source = {1,2,3,4}, target = {2,1,4,5};
        int[][] allowedSwaps = {{0,1}, {2,3}};
        System.out.println(minimumHammingDistance(source, target, allowedSwaps));
    }

    public static int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;

        // Step 1: Union-Find setup
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int[] swap : allowedSwaps) {
            union(parent, swap[0], swap[1]);
        }

        // Step 2: Group indices
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int root = find(parent, i);
            map.putIfAbsent(root, new HashMap<>());
            Map<Integer, Integer> freq = map.get(root);
            freq.put(source[i], freq.getOrDefault(source[i], 0) + 1);
        }

        // Step 3: Match target
        int mismatch = 0;

        for (int i = 0; i < n; i++) {
            int root = find(parent, i);
            Map<Integer, Integer> freq = map.get(root);

            if (freq.getOrDefault(target[i], 0) > 0) {
                freq.put(target[i], freq.get(target[i]) - 1);
            } else {
                mismatch++;
            }
        }

        return mismatch;
    }

    private static int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]); // path compression
        }
        return parent[x];
    }

    private static void union(int[] parent, int a, int b) {
        int rootA = find(parent, a);
        int rootB = find(parent, b);
        if (rootA != rootB) {
            parent[rootA] = rootB;
        }
    }
}
