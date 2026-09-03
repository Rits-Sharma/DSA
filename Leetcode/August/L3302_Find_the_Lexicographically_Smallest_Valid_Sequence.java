package Leetcode.August;

public class L3302_Find_the_Lexicographically_Smallest_Valid_Sequence {
    public static void main(String[] args) {
        String word1 = "vbcca", word2 = "abc";
        int[] ans = validSequence(word1, word2);
        for (int ele : ans) System.out.print(ele + " ");
    }

    public static int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] suf = new int[n+1];
        int j = m-1;

        for (int i = n - 1; i >= 0; i -- ) {
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) j --;
            suf[i] = m - 1 - j;
        }

        int[] ans = new int[m];
        int k = 0;
        j=0;
        boolean used = false;

        for (int i = 0; i < n && k < m; i++) {
            if (word1.charAt(i) == word2.charAt(j)) {
                ans[k++] = i;
                j++;

            } else if (!used && suf[i + 1] >= m - j - 1) {
                ans[k++] = i;
                j++;
                used = true;
            }
        }
        return k == m ? ans : new int[0];
    }
}
