package Leetcode.August;

public class L2029_Stone_Game_IX {
    public static void main(String[] args) {
        int[] stones = {5,1,2,4,3};
        System.out.println(stoneGameIX(stones));
    }

    public static boolean stoneGameIX(int[] stones) {
        int[] freq = new int[3];

        for (int ele : stones) freq[ele % 3]++;

        int a = freq[1];
        int b = freq[2];
        int c = freq[0];

        if (c % 2 ==0) return a>0 && b>0;

        return Math.abs(a-b)>2;
    }
}
