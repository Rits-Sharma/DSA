package Leetcode;

import java.util.Arrays;

public class L1320_Minimum_Distance_to_Type_a_word {
    public static void main(String[] args) {
        String word = "CAKE";
        System.out.println(minimumDistance(word));
    }

    public static int minimumDistance(String word) {
        int n = word.length();
        // memo[i][other] will store the minimum cost to type the substring from index 'i' to the end,
        // given that the 'other' finger is at the character 'other' (0-25, or 26 for unplaced).
        int[][] memo = new int[n][27];

        // Initialize memoization table with -1 to indicate uncalculated states
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        // Start at index 0, with the "other" finger unplaced (represented by 26)
        return dp(word, 0, 26, memo);
    }

    private static int dp(String word, int i, int other, int[][] memo) {
        // Base case: we finished typing the word
        if (i == word.length()) {
            return 0;
        }

        // Return memoized result if already calculated
        if (memo[i][other] != -1) {
            return memo[i][other];
        }

        // Convert characters to 0-25 integers
        int curr = word.charAt(i) - 'A';
        // If it's the first character (i=0), prev is 'unplaced' (26)
        int prev = (i > 0) ? word.charAt(i - 1) - 'A' : 26;

        // Choice 1: Move the finger currently on 'prev' to 'curr'
        // The 'other' finger stays exactly where it is.
        int cost1 = getDist(prev, curr) + dp(word, i + 1, other, memo);

        // Choice 2: Move the 'other' finger to 'curr'
        // The finger left behind is now the one sitting on 'prev'.
        int cost2 = getDist(other, curr) + dp(word, i + 1, prev, memo);

        // Memoize and return the minimum cost
        memo[i][other] = Math.min(cost1, cost2);
        return memo[i][other];
    }

    private static int getDist(int c1, int c2) {
        // 26 represents an unplaced finger, cost to place it is 0
        if (c1 == 26) {
            return 0;
        }

        // Calculate coordinates on a 6-column keyboard
        int x1 = c1 / 6, y1 = c1 % 6;
        int x2 = c2 / 6, y2 = c2 % 6;

        // Manhattan distance
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
