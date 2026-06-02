package Leetcode.May;

import java.util.Arrays;

public class L3121_Count_the_Special_Character_II {
    public static void main(String[] args) {
        String word = "aaAbcBC";
        System.out.println(numberOfSpecialChars(word));
    }

    public static int numberOfSpecialChars(String word) {
        int[] lastLower = new int[26];
        int[] firstUpper = new int[26];

        // Initialize arrays with -1 to indicate "not seen yet"
        Arrays.fill(lastLower, -1);
        Arrays.fill(firstUpper, -1);

        // Single pass to record positions
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (Character.isLowerCase(ch)) {
                int idx = ch - 'a';
                lastLower[idx] = i; // Always update to get the LAST occurrence
            } else {
                int idx = ch - 'A';
                // Only update if it's the FIRST occurrence
                if (firstUpper[idx] == -1) {
                    firstUpper[idx] = i;
                }
            }
        }

        int specialCount = 0;

        // Verify the conditions for all 26 letters
        for (int i = 0; i < 26; i++) {
            // Both must exist, and the last lowercase must be before the first uppercase
            if (lastLower[i] != -1 && firstUpper[i] != -1 && lastLower[i] < firstUpper[i]) {
                specialCount++;
            }
        }

        return specialCount;
    }
}
