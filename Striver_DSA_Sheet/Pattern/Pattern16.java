package Striver_DSA_Sheet.Pattern;

public class Pattern16 {
    public static void main(String[] args) {
        char ch = 'A';
        int n = 5;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print((char)(ch+i));
            }
            System.out.println();
        }
    }
}
