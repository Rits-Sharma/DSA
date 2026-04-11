package Leetcode;

public class L392_IsSubsequence {
    public static void main(String[] args) {
        String s = "a", t = "abcde";
        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String sub, String original) {
        if (sub.length() > original.length()) return false;
        int i = 0, j = 0;
        char[] subString = sub.toCharArray();
        char[] originalString = original.toCharArray();
        while (i < subString.length && j < originalString.length) {
            if (subString[i] == originalString[j]) {
                i++;
            }
            j++;
        }
        return (i == subString.length);
    }
}
