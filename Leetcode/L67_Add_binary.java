package Leetcode;

public class L67_Add_binary {
    public static void main(String[] args) {
        String a = "1010", b = "1011"; // Example: 10 + 11 = 21 ("10101")
        System.out.println(addBinary(a,b));
        String c = "11", d = "1"; // Original example: 3 + 1 = 4 ("100")
        System.out.println(addBinary(c,d));
    }

    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            result.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }
}
