package Leetcode.April;

import java.util.ArrayList;
import java.util.List;

public class L2452_Words_with_two_edits {
    public static void main(String[] args) {
        String[] queries = {"word","note","ants","wood"}, dictionary = {"wood","joke","moat"};
        System.out.println(twoEditWords(queries, dictionary));
    }

    public static List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> validWords = new ArrayList<>();

        // Step 1: Grab one word at a time from our queries
        for (String query : queries) {

            // Step 2: Compare it against every word in the dictionary
            for (String dictWord : dictionary) {

                // Step 3: If it's a match (2 or fewer differences), save it!
                if (isCloseEnough(query, dictWord)) {
                    validWords.add(query);

                    // We found a match, so stop checking this query against the dictionary
                    // and move on to the next query word.
                    break;
                }
            }
        }

        return validWords;
    }

    // Helper method to literally just count the differences
    private static boolean isCloseEnough(String word1, String word2) {
        int differences = 0;

        for (int i = 0; i < word1.length(); i++) {
            // If the letters at the same spot don't match, count it as an "edit"
            if (word1.charAt(i) != word2.charAt(i)) {
                differences++;

                // The "Bail Out" Trick:
                // If we hit 3 differences, it's an automatic fail.
                // Stop checking the rest of the letters to save time!
                if (differences > 2) {
                    return false;
                }
            }
        }

        // If we made it through the whole word with 0, 1, or 2 differences, it's good!
        return true;
    }
}
