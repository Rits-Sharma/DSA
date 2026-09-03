package Leetcode.July;

public class L3499_Maximize_Active_Section_with_Trade_I {
    public static void main(String[] args) {
        String s = "00010";
        System.out.println(maxActiveSectionsAfterTrade(s));
    }

    public static int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int ones = 0, maxSum = 0, prevZeros = -1;

        int i = 0;
        while (i < n) {
            if (s.charAt(i) == '1') {
                ones++;
                i++;
            }
            else {
                int currZeros = 0;
                while (i < n && s.charAt(i) == '0') {
                    currZeros++;
                    i++;
                }
                if (prevZeros > 0) maxSum = Math.max(maxSum, prevZeros + currZeros);
                prevZeros = currZeros;
            }
        }

        return ones + maxSum;
    }
}
