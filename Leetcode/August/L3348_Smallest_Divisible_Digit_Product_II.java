package Leetcode.August;

public class L3348_Smallest_Divisible_Digit_Product_II {
    public static void main(String[] args) {
        String num = "1234";
        long t = 256;
        System.out.println(smallestNumber(num, t));
    }

    public static String smallestNumber(String num, long t) {
        long remainingFactor = t;

        for (int factor = 2; factor <= 9; factor++) {
            while (remainingFactor % factor == 0) {
                remainingFactor /= factor;
            }
        }

        if (remainingFactor > 1) return "-1";

        int len = num.length();

        long[] requiredFactor = new long[len+1];
        requiredFactor[0] = t;

        int firstZeroIndex = len - 1;
        char[] digit = num.toCharArray();

        for (int i = 0; i < len; i++) {
            if (digit[i] == '0') {
                firstZeroIndex = i;
                break;
            }

            requiredFactor[i+1] = requiredFactor[i] / gcd(requiredFactor[i], digit[i] - '0');
        }

        if (requiredFactor[len] == 1) return num;

        for (int i = firstZeroIndex; i >= 0; i--) {
            while (++digit[i] <= '9') {
                long currentNeed = requiredFactor[i] / gcd(requiredFactor[i], digit[i] - '0');
                int candidateDigit = 9;

                for (int j = len-1; j > i; j--) {
                    while (currentNeed % candidateDigit != 0) candidateDigit--;

                    currentNeed /= candidateDigit;

                    digit[j] = (char) ('0' + candidateDigit);
                }

                if (currentNeed == 1) return new String(digit);
            }
        }

        StringBuilder answer = new StringBuilder();

        long remaining = t;

        for (int i = 9; i >= 2; i--) {
            while (remaining % i == 0) {
                answer.append((char) ('0' + i));
                remaining /= i;
            }
        }

        int extraOnes = Math.max(len + 1 - answer.length(), 0);
        while (extraOnes-- > 0) answer.append('1');

        return answer.reverse().toString();
    }

    private static long gcd(long first, long second) {
        while (second != 0) {
            long temp = second;
            second = first % second;
            first = temp;
        }
        return first;
    }

}
