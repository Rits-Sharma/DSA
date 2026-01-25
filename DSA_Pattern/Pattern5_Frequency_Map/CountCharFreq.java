package DSA_Pattern.Pattern5_Frequency_Map;

public class CountCharFreq {
    public static void main(String[] args) {
        String str = "This is plane";
        int[] countChFreq = countFreq(str);
        for (int i = 0; i < countChFreq.length; i++) {
            if(countChFreq[i] != 0) {
                System.out.println((char)('a'+i) + " = " + countChFreq[i]);
            }
        }
    }

    public static int[] countFreq(String str) {
        int[] freq = new int[26];
        String str1 = str.toLowerCase();
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                int idx = ch - 'a';
                freq[idx]++;
            }
        }
        return freq;
    }
}
