package Leetcode.April;

public class L2833_Furthest_Point_From_Origin {
    public static void main(String[] args) {
        String moves = "_R__LL_";
        System.out.println(furthestDistanceFromOrigin(moves));
    }

    public static int furthestDistanceFromOrigin(String moves) {
        int len = moves.length();
        int l = 0, r = 0, u = 0;
        for (int i = 0; i < len; i++) {
            if (moves.charAt(i) == 'R') r++;
            else if (moves.charAt(i) == 'L') l++;
            else u++;
        }
        return Math.abs(l -r) + u;
    }
}
