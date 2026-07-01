package Leetcode.June;

public class L3612_Process_String_with_Special_Operations_I {
    public static void main(String[] args) {
        String s = "a#b%*";
        System.out.println(processStr(s));
    }

    public static String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') sb.append(c);
            else if (c == '#') duplicateStr(sb);
            else if (c == '%') reverseStr(sb);
            else if (c == '*') removeLastChar(sb);
        }
        return sb.toString();
    }

    private static void reverseStr(StringBuilder s) {
        s.reverse();
    }

    private static void duplicateStr(StringBuilder s) {
        s.append(s);
    }

    private static void removeLastChar(StringBuilder sb) {
        if (!sb.isEmpty()) {
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
