package Leetcode.July;

import java.util.HashSet;
import java.util.Stack;

public class L1081_Smallest_Subsequence_of_Distinct_Characters {
    public static void main(String[] args) {
        System.out.println(smallestSubsequence("cbacdcbc"));    // acdb -> cbad
    }

    public static String smallestSubsequence(String s) {
        int n = s.length();
        int[] last = new int[26];

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            last[ch - 'a'] = i;
        }

        Stack<Integer> st = new Stack<>();
        HashSet<Character> hSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (hSet.contains(ch)) continue;
            while (!st.empty()) {
                char prev = s.charAt(st.peek());
                if (prev > ch && last[ch - 'a'] > i) {
                    st.pop();
                    hSet.remove(prev);
                } else break;
            }

            st.push(i);
            hSet.add(ch);
        }

        StringBuilder sb = new StringBuilder();
        while (!st.empty()) {
            sb.append(s.charAt(st.pop()));
        }
        return sb.reverse().toString();
    }

//    public static String smallestSubsequence(String s) {
//        StringBuilder sb = new StringBuilder();
//
//        ArrayList<Character> charArr = new ArrayList<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (!charArr.contains(c)) charArr.add(c);
//        }
//
//        for (Character ele : charArr) {
//            sb.append(ele);
//        }
//
//        return sb.toString();
//    }

}


// Leetcode 316 is same as this question
