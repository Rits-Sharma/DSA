package Leetcode;

public class L792_Matching_Sequence {
    public static void main(String[] args) {
        String s = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        System.out.println(numMatchingSubseq(s, words));
    }

    public static int numMatchingSubseq(String s, String[] words) {
        int countSequence = 0;

        for (String word : words) {
            int i = 0, j = 0;
            while (i < s.length() && j < word.length()) {
                if (s.charAt(i) == word.charAt(j)) {
                    j++;
                }
                i++;
            }
            if (j == word.length()) {
                countSequence++;
            }
        }
        return countSequence;
    }
}
