package Leetcode.May;

public class L1871_Jump_Game_VII {
    public static void main(String[] args) {
        String s = "011010";
        int minJump = 2, maxJump = 3;
        System.out.println(canReach(s, minJump, maxJump));
    }

    public static boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if (s.charAt(n - 1) == '1') {
            return false;
        }

        boolean[] dp = new boolean[n];
        dp[0] = true;
        int availableJumps = 0;

        for (int i = 1; i < n; i++) {
            if (i >= minJump && dp[i - minJump]) {
                availableJumps++;
            }
            if (i > maxJump && dp[i - maxJump - 1]) {
                availableJumps--;
            }
            if (s.charAt(i) == '0' && availableJumps > 0) {
                dp[i] = true;
            }
        }
        return dp[n - 1];
    }
}
