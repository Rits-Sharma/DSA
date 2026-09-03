package Leetcode.August;

public class L2213_Longest_Substring_of_One_Repeating_Character {
    public static void main(String[] args) {

    }

    public static int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        char[] arr = s.toCharArray();
        int n = queryIndices.length;

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
                arr[queryIndices[i]] = queryCharacters.charAt(i);

                int longest = 1, current = 1;

            for (int j = 1; j < arr.length; j++) {
                if (arr[j] == arr[j-1]) current++;
                else current = 1;

                longest = Math.max(longest, current);
            }

            ans[i] = longest;
        }
        return ans;
    }
}
