package Leetcode.August;

public class L3345_Smallest_Divisible_Digit_Product_I {
    public static void main(String[] args) {
        int n = 15, t = 3;
        System.out.println(smallestNumber(n, t));
    }

    public static int smallestNumber(int n, int t) {
        int product = product(n);
        if ((product % t) == 0) return n;
        else return smallestNumber(n+1, t);
    }

    public static int product(int num) {
        int prod = 1;
        while(num > 0) {
            int rem = num % 10;
            prod *= rem;
            num /= 10;
        }
        return prod;
    }
}
