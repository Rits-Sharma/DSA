package Leetcode.June;

public class L1967_Number_of_Strings_That_Appear_as_Substrings {
    public static void main(String[] args) {
        String[] patterns = {"a","abc","bc","d"};
        String words = "abc";
        System.out.println(numOfStrings(patterns, words));
    }

    public static int numOfStrings(String[] patterns, String word) {
        int count = 0;

        for(String str : patterns) {
            if (word.contains(str)) count++;
        }

        return count;
    }
}
