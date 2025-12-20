package Leetcode;

import java.util.Scanner;
import java.util.Stack;

public class Leetcode20 {

    public static void main(String[] args) {
        Leetcode20 leetcode20 = new Leetcode20();
        Scanner sc = new Scanner(System.in);
        String str;
        System.out.print("Enter a string of parenthesis: ");
        str = sc.nextLine();
        System.out.println(leetcode20.isValid(str));
    }

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        if(s.isEmpty()) return true;
        if (s.charAt(0) == ')' || s.charAt(0) == '}' || s.charAt(0) == ']') return false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[')
                st.push(ch);
            else {
                if (st.isEmpty()) return false;
                char top = st.pop();
                if (!isEqual(top, ch)) return false;
            }
        }
        return st.isEmpty();
    }
    public boolean isEqual(char open, char close) {
        return ((open=='(' && close==')') || (open=='{' && close=='}') || (open=='[' && close==']'));
    }
}
