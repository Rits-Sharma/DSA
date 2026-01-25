package Leetcode;

public class L28_Find_Index_Of_First_Occurrence {
    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "sad";
        System.out.println("Occurrence index: " + strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        if(needle.isEmpty()) return 0;
        if(haystack.length() < needle.length()) return -1;
        if(haystack.equals(needle)) return 0;
        int index = -1;
        for (int i = 0; i < haystack.length(); i++) {
            for (int j = i; j < needle.length(); j++) {
                if(haystack.charAt(j) == needle.charAt(j)) index++;
            }
            if(index > needle.length()) return index;
        }
        return index;
    }
}
