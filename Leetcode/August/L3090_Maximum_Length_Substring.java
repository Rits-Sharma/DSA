package Leetcode.August;

public class L3090_Maximum_Length_Substring {
    public static void main(String[] args) {
        String s = "bcbbbcba";
        System.out.println(maximumLengthSubstring(s));
    }

    public static int maximumLengthSubstring(String s) {
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            int[] freq = new int[26];
            for (int j = i; j < s.length(); j++) {
                freq[s.charAt(j) - 'a']++;
                if (freq[s.charAt(j) - 'a'] > 2) break;

                maxLen = Math.max(maxLen, j - i + 1);
            }
        }
        return maxLen;
    }
}
