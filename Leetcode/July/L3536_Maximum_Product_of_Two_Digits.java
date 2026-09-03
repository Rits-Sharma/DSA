package Leetcode.July;

import java.util.ArrayList;
import java.util.Arrays;

public class L3536_Maximum_Product_of_Two_Digits {
    public static void main(String[] args) {
        int n = 437;
        System.out.println(maxProduct(n));
    }

    public static int maxProduct(int n) {
        ArrayList<Integer> numList = new ArrayList<>();

        while (n > 0) {
            int rem = n % 10;
            numList.add(rem);
            n /= 10;
        }

        int[] numListArray = numList.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(numListArray);
        int m = numListArray.length;
        return numListArray[m-1] * numListArray[m-2];
    }

//    public int maxProduct2(int n) {
//        int max1 = 0, max2 = 0;
//
//        while (n > 0) {
//            int digit = n % 10;
//
//            if (digit > max1) {
//                max2 = max1;
//                max1 = digit;
//            } else if (digit > max2) {
//                max2 = digit;
//            }
//
//            n /= 10;
//        }
//
//        return max1 * max2;
//    }
}
