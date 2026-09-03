package Leetcode.August;

public class L3622_Check_Divisibility_by_Digit_Sum_and_Product {
    public static void main(String[] args) {
        System.out.println(checkDivisibility(10));
    }

    public static boolean checkDivisibility(int n) {
        int  sum = 0, product = 1;
        int original = n;
        while (n > 0) {
            int rem = n % 10;
            sum += rem;
            product *= rem;
            n /= 10;
        }
        return (original % (sum + product)) == 0;
    }
}
