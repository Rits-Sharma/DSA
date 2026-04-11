package Leetcode;

public class L2839_Check_Equal_String {
    public static void main(String[] args) {
        String s1 = "bnxw", s2 = "bwxn";
        System.out.println(canBeEqual(s1, s2));
    }

    public static boolean canBeEqual(String s1, String s2) {
        int i = 0, j = 2;
        StringBuilder sb = new StringBuilder(s1.length());
        sb.append(s1);
        while (j < 4) {
            char a = sb.charAt(i), b = sb.charAt(j);
            if (a != b) {
                sb.setCharAt(i, b);
                sb.setCharAt(j, a);
            }
            i++; j++;
        }
        return sb.toString().equals(s2);
    }
}
