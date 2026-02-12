package Leetcode;

public class L443_String_Compression {
    public static void main(String[] args) {
        char[] chars = {'a','a','b','b','c','c','c'};
        System.out.println(compress(chars));
    }

    public static int compress(char[] chars) {
        int index = 0, indexCount = 0;
        char currChar;
        for (int i = 0; i < chars.length; i++) {
            currChar = chars[i];
            int count = 0;
            while (i < chars.length && chars[i] == currChar) {
                count++;
                i++;
            }
            i--;
            chars[index++] = currChar;
            indexCount++;
            System.out.println(count);
            if (count > 1) {
                String countStr = String.valueOf(count);
                for (char c : countStr.toCharArray()) {
                    chars[index++] = c;
                    indexCount++;
                }
            }
        }
        return indexCount;
    }
}
