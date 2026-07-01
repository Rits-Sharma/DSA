package Leetcode.June;

import java.util.HashMap;

public class L1189_Maximum_Number_of_Balloons {
    public static void main(String[] args) {
        String text = "loonbalxballpoon";
        System.out.println(maxNumberOfBalloons2(text));
    }

    public static int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] charArray = text.toCharArray();

        for (char c : charArray) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int b = map.getOrDefault('b', 0);
        int a = map.getOrDefault('a', 0);
        int l = map.getOrDefault('l', 0) / 2;
        int o = map.getOrDefault('o', 0) / 2;
        int n = map.getOrDefault('n', 0);

        return Math.min(b, Math.min(a, Math.min(l, Math.min(o, n))));
    }

    public static int maxNumberOfBalloons2(String text) {
        int b_freq = 0;
        int a_freq = 0;
        int l_freq = 0;
        int o_freq = 0;
        int n_freq = 0;

        for(char ch: text.toCharArray()) {
            if(ch == 'b') b_freq++;
            else if(ch == 'a') a_freq++;
            else if(ch == 'l') l_freq++;
            else if(ch == 'o') o_freq++;
            else if(ch == 'n') n_freq++;
        }
        return Math.min(Math.min(b_freq, a_freq), Math.min(n_freq, Math.min(l_freq/2, o_freq/2)));
    }

}
