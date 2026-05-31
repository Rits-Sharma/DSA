package Striver_DSA_Sheet.Pattern;

public class Pattern18 {
    public static void main(String[] args) {
        char ch = 'A';
        int n = 5;
        for (int i = 0; i <= n; i++) {
            for (int j = n-1; j >= n-i; j--) {
                System.out.print((char)(ch+j));
            }
            System.out.println();
        }
    }
}
