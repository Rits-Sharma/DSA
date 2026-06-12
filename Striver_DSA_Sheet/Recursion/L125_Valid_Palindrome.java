package Striver_DSA_Sheet.Recursion;

public class L125_Valid_Palindrome {
    public static void main(String[] args) {
        String s = "0P";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) return true;
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left)))
                left++;
            else if (!Character.isLetterOrDigit(s.charAt(right)))
                right--;
            else if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                return false;
            else {
                left++;
                right--;
            }
        }
        return true;
    }
}
