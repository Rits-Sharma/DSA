package Leetcode.July;

public class L3756_Concatenate_NonZero_Digits_and_Multiply_by_Sum_II {
    public static void main(String[] args) {
        String  s = "10203004";
        int[][] queries = {{0,7},{1,3},{4,6}};
        L3756_Concatenate_NonZero_Digits_and_Multiply_by_Sum_II l3756 =
                new L3756_Concatenate_NonZero_Digits_and_Multiply_by_Sum_II();
        int[] ans = l3756.sumAndMultiply(s, queries);
        for (int i : ans) System.out.print(i + " ");
    }


    /*
    public int[] sumAndMultiply(String s, int[][] queries) {
        int[] ans = new int[queries.length];
        int mod = 1_000_000_007;

        for (int i = 0; i < queries.length; i++) {
            long num = 0, sum = 0;
            int reversed = reverse(strToInt(s, queries[i][0], queries[i][1] + 1));

            while (reversed > 0) {
                int last = reversed % 10;
                sum += last;
                if (last != 0) num = num * 10 + last;
                reversed /= 10;
            }
            ans[i] = (int) ((num * sum) % mod);
        }

        return ans;
    }

    public int strToInt(String s, int start, int end) {
        String str = s.substring(start, end);
        return Integer.parseInt(str);
    }

    public int reverse(int n) {
        int rev = 0;

        while (n > 0) {
            int rem = n % 10;
            rev = rev * 10 + rem;
            n /= 10;
        }
        return rev;
    }
    */

    int mod = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        // Time: O(n + q), Space: O(n + q)
        long[] preSum = new long[n + 1]; // presum[i]  = prefix digit sum up to index i (exclusive)
        long[] conVal = new long[n + 1]; // conval[i]  = concatenated numeric value of non-zero digits up to i
        int[]  count  = new int[n + 1];  // count[i]   = number of non-zero digits up to index i
        long[] pow10  = new long[n + 1]; // pow10[i]   = 10^i % mod

        for (int i = 1; i <= n; i++) {
            int num = s.charAt(i - 1) - '0';

            preSum[i] = (preSum[i - 1] + num) % mod;

            if (num == 0) {
                // Zero digits don't contribute to the concatenated value
                conVal[i] = conVal[i - 1];
                count[i]  = count[i - 1];
            } else {
                conVal[i] = (conVal[i - 1] * 10 + num) % mod;
                count[i]  = count[i - 1] + 1;
            }
        }

        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % mod;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0], right = queries[i][1];

            // Sum of digits in [left, right]
            long sum = (preSum[right + 1] - preSum[left] + mod) % mod;

            // Extract concatenated value of non-zero digits in [left, right]
            // by stripping the left prefix from the right prefix:
            // range = conval[right+1] - conval[left] * 10^(non-zero digit count in range)
            long leftPart = conVal[left];
            long rightPart = conVal[right + 1];
            int  diff      = count[right + 1] - count[left]; // non-zero digit count in range
            long power     = pow10[diff];
            long range     = (rightPart - (leftPart * power) % mod + mod) % mod;

            ans[i] = (int) (range * sum % mod);
        }

        return ans;
    }
}
