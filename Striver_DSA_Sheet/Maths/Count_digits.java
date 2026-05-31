package Striver_DSA_Sheet.Maths;

public class Count_digits {
    public static void main(String[] args) {
        int n = -12345;
        int count = 0;
        n = Math.abs(n);
        while (n > 0) {
            n = n / 10;
            count++;
        }
        System.out.println(count);
    }
}
