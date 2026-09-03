package Leetcode.August;

import java.util.ArrayList;

public class L1927_Sum_Game {
    public static void main(String[] args) {
        String num = "5023";
        System.out.println(sumGame(num));
    }

    public static boolean sumGame(String num) {
        int n = num.length();
        int n0 = 0, q0 = 0, n1 = 0, q1 = 0;

        for (int i = 0; i < n / 2; i++) {
            if (num.charAt(i) == '?') q0++;
            else n0 += num.charAt(i) - '0';
        }
        for (int i = n / 2; i < n; i++) {
            if (num.charAt(i) == '?') q1++;
            else n1 += num.charAt(i) - '0';
        }

        return (q0 + q1) % 2 == 1 || n0 - n1 != (q1 - q0) * 9 / 2;
    }
}
