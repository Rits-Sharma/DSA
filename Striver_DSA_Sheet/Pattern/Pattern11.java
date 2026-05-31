package Striver_DSA_Sheet.Pattern;

public class Pattern11 {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            int num = (i % 2 == 0) ? 0 : 1; // starting number based on row number
            for (int j = 1; j <= i; j++) {
                System.out.print(num);
                num = (num == 1) ? 0 : 1; // toggle between 1 and 0
            }
            System.out.println();
        }
    }
}
