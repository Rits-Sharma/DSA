package Leetcode.June;

import java.util.HashMap;

public class L3838_Weighted_Word_Mapping {
    public static void main(String[] args) {
        String[] words = {"abcd","def","xyz"};
        int[] weights = {5,3,12,14,1,2,3,2,10,6,6,9,7,8,7,10,8,9,6,9,9,8,3,7,7,2};
        System.out.println(mapWordWeights(words, weights));
    }

    public static String mapWordWeights(String[] words, int[] weights) {

        StringBuilder sb = new StringBuilder(words.length);

        HashMap<Integer, Character> map = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            map.put(i, (char)('z' - i));
        }
        
        for (String s : words) {
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                sum += weights[s.charAt(i) - 'a'];
            }
            sum %= 26;
            sb.append(map.get(sum));
        }
        return sb.toString();
    }
}