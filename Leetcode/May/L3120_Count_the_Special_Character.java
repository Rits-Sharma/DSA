package Leetcode.May;

import java.util.HashSet;
import java.util.Set;

public class L3120_Count_the_Special_Character {
    public static void main(String[] args) {
        String word = "aaAbcBC";
        System.out.println(numberOfSpecialChars(word));
    }

    public static int numberOfSpecialChars(String word) {
        Set<Character> set = new HashSet<>();
        for (char c : word.toCharArray()) {
            set.add(c);
        }

        int count = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            if (set.contains(c) && set.contains(Character.toUpperCase(c))) {
                count++;
            }
        }
        return count;
    }
}
