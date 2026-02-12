package Leetcode;

import java.math.BigInteger;

public class L415_Add_string {
    public static void main(String[] args) {
        String num1 = "6913259244", num2 = "71103343";
        L415_Add_string obj = new L415_Add_string();
        System.out.println(obj.addStrings(num1, num2));
    }

    public String addStrings(String num1, String num2) {
//        long a = Long.parseLong(num1);
//        long b = Long.parseLong(num2);
//        long sum = a + b;
//        return String.valueOf(sum);

        BigInteger bigInt = new BigInteger(num1);
        BigInteger bigInt1 = new BigInteger(num2);
        BigInteger sum = bigInt.add(bigInt1);
        return sum.toString();
    }
}
