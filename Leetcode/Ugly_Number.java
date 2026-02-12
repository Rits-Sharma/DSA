package Leetcode;

public class Ugly_Number {
    public static void main(String[] args) {
        System.out.println(isUgly(1));
    }

    public static boolean isUgly(int n) {
        boolean isUgly = true;
        if (n < 1) return false;
        while (n % 2 == 0) n /= 2;
        while (n % 3 == 0) n /= 3;
        while (n % 5 == 0) n /= 5;
        if (n != 1) isUgly = false;
        return isUgly;
    }
}
