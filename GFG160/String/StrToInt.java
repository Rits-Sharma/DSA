package GFG160.String;

public class StrToInt {
    public static void main(String[] args) {
        String s = "-1231231231311133";
        System.out.println(atoi(s));
    }

    public static int atoi(String str) {
        int ans = 0;
        boolean isNegative = (str.charAt(0) == '-');

        for (int i = 1; i < str.length(); i++) {
            if (isInt(str.charAt(i))) {
                if (ans > Integer.MAX_VALUE / 10) {
                    if (isNegative) return Integer.MIN_VALUE;
                    return Integer.MAX_VALUE;
                }
                ans = ans * 10 + (str.charAt(i) - '0');
            } else {
                break;
            }
        }

        return isNegative ? -ans : ans;
    }

    public static boolean isInt(char ch) {
        return  ch >= '0' && ch <= '9';
    }
}
