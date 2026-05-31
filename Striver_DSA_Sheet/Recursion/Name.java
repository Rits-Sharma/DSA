package Striver_DSA_Sheet.Recursion;

public class Name {
    public static void main(String[] args) {
        print("Ashish", 3);
    }

    public static void print(String name, int n) {
        if (n < 1) return;
        print(name, n-1);
        System.out.println(name);
    }
}
