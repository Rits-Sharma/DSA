package Leetcode.July;

public class L3658_GCD_of_Odd_and_Even_Sums {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(gcdOddEvenSums(n));
    }

    public static int gcdOddEvenSums(int n) {
        int oddSums = n * n;
        int evenSums = n * (n + 1);

        return L3336_Number_of_Subsequences_With_Equal_GCD.gcd(oddSums, evenSums);
    }

//    public static int gcdOddEvenSums2(int n) {
//        return n;
//    }

//    public static int gcd(int a, int b) {
//        if (b == 0) return a;
//        return gcd(b, a % b);
//    }
}
