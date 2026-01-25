package Leetcode;

import java.util.Scanner;
import java.util.Stack;

public class L20_Valid_Parentheses {

    public static void main(String[] args) {
        L20_Valid_Parentheses l20ValidParentheses = new L20_Valid_Parentheses();
        Scanner sc = new Scanner(System.in);
        String str;
        System.out.print("Enter a string of parenthesis: ");
        str = sc.nextLine();
        System.out.println(l20ValidParentheses.isValid(str));
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
