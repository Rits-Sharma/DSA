package Leetcode.May;

import java.util.*;

public class L3629_Minimum_Jumps {
    public static void main(String[] args) {
        int[] nums = {2,3,4,7,9};
        System.out.println(minJumps(nums));
    }

    public static int minJumps(int[] nums) {
        int n = nums.length;
        if(n==1)
            return 0;

        HashMap<Integer, List<Integer>> hmap = new HashMap<>();
        int max = -1; //
        // O(n)
        for(int i=0; i<n; i++) {
            hmap.computeIfAbsent(nums[i], k->new ArrayList<>()).add(i);
            max = Math.max(nums[i], max);
        }

        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[0] = 0; // 0th index

        // BFS
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        // T.C - O(n*sqrt(max))
        // S.C. - O(n)
        while(!q.isEmpty()) {
            int curr = q.remove();

            List<Integer> nextjumps = new ArrayList<>();
            // adjacent elements
            if(curr-1>=0)
                nextjumps.add(curr-1);
            if(curr+1<n)
                nextjumps.add(curr+1);

            // prime teleportation
            // O(sqrt(num))
            if(isPrime(nums[curr])) {
                int p = nums[curr];
                for(int i = p; i <=max; i +=p) {
                    if(hmap.containsKey(i)) {
                        nextjumps.addAll(hmap.get(i));
                        hmap.remove(i);
                    }
                }
            }
            for(int next : nextjumps) {
                if(dist[next]==-1) {
                    dist[next] = dist[curr] + 1;
                    if(next==n-1) return dist[next];
                    q.add(next);
                }
            }
        }
        return dist[n-1];
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) return false;
        return true;
    }
}
