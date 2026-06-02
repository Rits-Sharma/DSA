package Leetcode.April;

import java.util.Arrays;

public class L3464_Maximize_the_Distance_Between_Points {
    public static void main(String[] args) {
        int side = 2, k = 4;
        int[][] points = {{0,0}, {1,2}, {2,0}, {2,2}, {2,1}};
        System.out.println(maxDistance(side, points, k));
    }

    public static int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        long[] pos = new long[n];
        long S = side;

        // Step 1: Map 2D points to 1D clockwise positions
        for (int i = 0; i < n; i++) {
            long x = points[i][0];
            long y = points[i][1];
            if (x == 0) pos[i] = y;
            else if (y == S) pos[i] = S + x;
            else if (x == S) pos[i] = 3 * S - y;
            else pos[i] = 4 * S - x;
        }
        Arrays.sort(pos);

        long perimeter = 4 * S;
        int low = 1, high = side;
        int result = 0;

        // Step 2: Binary Search on the possible distance 'd'
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canFeasible(mid, pos, k, perimeter)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    private static boolean canFeasible(int d, long[] pos, int k, long perimeter) {
        int n = pos.length;
        // Optimization: At least one point of the optimal set must be in this range
        long startLimit = pos[0] + perimeter / k;

        for (int i = 0; i < n && pos[i] <= startLimit; i++) {
            int count = 1;
            long currentPos = pos[i];
            int currentIdx = i;

            // Greedily pick the next k-1 points
            for (int j = 1; j < k; j++) {
                long target = currentPos + d;
                int nextIdx = lowerBound(pos, target, currentIdx + 1, n);
                if (nextIdx == n) {
                    count = -1;
                    break;
                }
                currentPos = pos[nextIdx];
                currentIdx = nextIdx;
                count++;
            }

            // Step 3: Check wrap-around distance back to the first point
            if (count == k && (pos[i] + perimeter - currentPos) >= d) {
                return true;
            }
        }
        return false;
    }

    // Standard lower_bound to find the first element >= target
    private static int lowerBound(long[] arr, long target, int start, int end) {
        int left = start, right = end - 1;
        int ans = end;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
