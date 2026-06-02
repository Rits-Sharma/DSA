package Leetcode.May;

public class L788_Rotated_Digits {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(rotatedDigits(n));
    }

    public static int rotatedDigits(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isGood(i)) count++;
        }
        return count;
    }
    private static boolean isGood(int n) {
        int curr = n;
        boolean isValid = false;
        while (curr > 0) {
            int digit = curr % 10;
            if (digit == 3 || digit == 4 || digit == 7) return false;
            if (digit == 2 || digit == 5 || digit == 6 || digit == 9) isValid = true;
            curr /= 10;
        }
        return isValid;
    }
}
