package Leetcode;

public class L3783_Mirror_Distance_of_an_Integer {
    public static void main(String[] args) {
        System.out.println(mirrorDistance(25));
    }

    public static int mirrorDistance(int n) {
        int reverse = reverse(n);
        return Math.abs(n - reverse);
    }

    public static int reverse(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            n /= 10;
            res = res * 10 + temp;
        }
        return res;
    }
}
