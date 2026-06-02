package Leetcode.May;

public class L796_Rotate_String {
    public static void main(String[] args) {
        String s = "abcde", goal = "cdeab";
        System.out.println(rotateString(s, goal));
    }

    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        String str = s + s;
        return str.contains(goal);
    }
}
