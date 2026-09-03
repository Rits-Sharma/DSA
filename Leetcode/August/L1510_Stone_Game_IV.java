package Leetcode.August;

public class L1510_Stone_Game_IV {
    public static void main(String[] args) {

    }

    public static boolean winnerSquareGame(int n) {
        if (n == 1) return true;
        if (n == 2) return false;

        int remove = 0;
        for (int i = 0; i <= n; i++) {
            if (i*i <= n) remove = i;
        }
        return !winnerSquareGame(n - remove*remove);
    }

    public static int sqrt(int n) {
        return (int)Math.sqrt(n);
    }
}
