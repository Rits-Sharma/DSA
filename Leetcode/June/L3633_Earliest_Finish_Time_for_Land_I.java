package Leetcode.June;

public class L3633_Earliest_Finish_Time_for_Land_I {
    public static void main(String[] args) {
        int[] landStartTime = {2, 8}, landDuration = {4, 1};
        int[] waterStartTime = {6}, waterDuration = {3};
        System.out.println(earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration));
    }

    public static int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int m = landDuration.length, n = waterDuration.length;

        int landFinishTime = Integer.MAX_VALUE, waterFinishTime = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            landFinishTime = Math.min(landFinishTime, landStartTime[i] + landDuration[i]);
        }
        for (int i = 0; i < n; i++) {
            int curr = Math.max(landFinishTime, waterStartTime[i]) + waterDuration[i];
            ans = Math.min(ans, curr);
        }

        for (int i = 0; i < n; i++) {
            waterFinishTime = Math.min(waterFinishTime, waterStartTime[i] + waterDuration[i]);
        }
        for (int i = 0; i < m; i++) {
            int curr = Math.max(waterFinishTime, landStartTime[i]) + landDuration[i];
            ans = Math.min(ans, curr);
        }

        return ans;
    }
}
