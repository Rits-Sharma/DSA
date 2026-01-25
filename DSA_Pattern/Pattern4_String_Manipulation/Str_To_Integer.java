package DSA_Pattern.Pattern4_String_Manipulation;

public class Str_To_Integer {
    public static void main(String[] args) {
        String str = "-123as1253";
//        System.out.println(Integer.parseInt(str));
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(isDigit(ch)) System.out.print(ch);
        }
    }

    public static boolean isDigit(char ch) {
        return ch == '1' || ch == '2' || ch == '3' || ch == '4' || ch == '5' || ch == '6' || ch == '7' || ch == '8' || ch == '9' || ch == '0';
    }
}
