package Leetcode.July;

public class L3754_Concatenate_NonZero_Digits_and_Multiply_by_Sum_I {
    public static void main(String[] args) {
        int n = 10203004;
        L3754_Concatenate_NonZero_Digits_and_Multiply_by_Sum_I l3754 =
                new L3754_Concatenate_NonZero_Digits_and_Multiply_by_Sum_I();
        System.out.println(l3754.sumAndMultiply(n));
    }

    public long sumAndMultiply(int n) {
        long num = 0, sum = 0;
        long reversed = reverse(n);

        while (reversed > 0) {
            long last = reversed % 10;
            sum += last;
            if (last != 0) num = num * 10 + last;
            reversed /= 10;
        }

        return num * sum;
    }

    public long reverse(int n) {
        long rev = 0;

        while (n > 0) {
            int rem = n % 10;
            rev = rev * 10 + rem;
            n /= 10;
        }

        return rev;
    }
}
