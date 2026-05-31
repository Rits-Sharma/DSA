package Striver_DSA_Sheet.Pattern;

public class Pattern17 {
    public static void main(String[] args) {
        int n = 4;
        char ch = 'A';
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= (n-i); j++) System.out.print(" ");
            for (int j = 0; j < i; j++) System.out.print((char)(ch+j));
            for (int j = i-1; j > 0; j--) System.out.print((char)(ch+j-1));
            System.out.println();
        }
    }
}
