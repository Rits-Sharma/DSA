package Leetcode;

public class L151_Reverse_String_Words {
    public static void main(String[] args) {
        String s = "  hello world  ";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split(" ");
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!arr[i].isEmpty()) {
                if (!sb.isEmpty()) {
                    sb.append(" ");
                }
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
}
