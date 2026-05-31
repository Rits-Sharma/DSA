package Leetcode;

import java.util.Arrays;

public class L1665_Minimum_Initial_Energy {
    public static void main(String[] args) {
        int[][] tasks = {{1,2}, {2,4}, {4,8}};
        System.out.println(minimumEffort(tasks));
    }

    public static int minimumEffort(int[][] tasks) {
        int ans = 0;
        int curr = 0;
        Arrays.sort(tasks, (a, b)-> {
            int t1 = a[1]-a[0];
            int t2 = b[1]-b[0];
            return t2-t1;
        });
        for (int[] task : tasks) {
            if (task[1] > curr) {
                ans += (task[1] - curr);
                curr = task[1];
            }
            curr = curr - task[0];
        }
        return ans;
    }
}
