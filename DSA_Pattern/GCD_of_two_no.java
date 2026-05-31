package DSA_Pattern;

public class GCD_of_two_no {
    public static void main(String[] args) {
        int a = 36, b = 60;
        System.out.println(gcd(a, b));
    }

    public static int gcd(int a, int b) {
        if (a==0) return b;
        if (b==0) return a;
        int max = Math.max(a,b);
        int min = Math.min(a,b);
        while (min != 0) {
            int temp = min;
            min = max % min;
            max = temp;
        }
        return max;
    }
}
