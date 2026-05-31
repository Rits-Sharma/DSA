package Striver_DSA_Sheet.Maths;

public class L7_reverse_number {
    public static void main(String[] args) {
        int n = 123, rev = 0;
        int positive = Math.abs(n);
        while (positive > 0) {
            int rem = positive % 10;
            rev = rev * 10 + rem;
            positive /= 10;
        }
        System.out.println((n>0)?rev : -rev);
    }
}
