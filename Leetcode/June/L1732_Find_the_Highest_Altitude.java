package Leetcode.June;

public class L1732_Find_the_Highest_Altitude {
    public static void main(String[] args) {
        int[] gain = {-4,-3,-2,-1,4,3,2};
        System.out.println(largestAltitude(gain));
    }

    public static int largestAltitude(int[] gains) {
        int max = 0;
        int currSum = 0;

        for (int gain : gains) {
            currSum += gain;
            max = Math.max(max, currSum);
        }
        return max;
    }
}
