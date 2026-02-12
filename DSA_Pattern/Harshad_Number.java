package DSA_Pattern;

import java.util.Scanner;

// A Harshad number (also called a Niven number) is a positive integer that is divisible by the sum of its digits.
public class Harshad_Number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num, num_sum = 0;
        System.out.print("Enter a number: ");
        num = sc.nextInt();
        int check = num;
        while(check != 0) {
            int rem = check % 10;
            num_sum += rem;
            check /= 10;
        }
        if (num % num_sum == 0) System.out.println(num + " is a harshad number.");
        else System.out.println(num + " is not a harshad number.");

    }
}
