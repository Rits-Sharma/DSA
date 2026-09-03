package Leetcode.September;

import java.util.Arrays;

public class L836_Rectangle_Overlap {
    public static void main(String[] args) {
        int[] rect1 = {0,0,1,1}, rect2 = {1,0,2,1};
        System.out.println(isRectangleOverlap(rect1, rect2));
    }

    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int xOverlap = Math.min(rec1[2], rec2[2]) - Math.max(rec1[0], rec2[0]);
        int yOverlap = Math.min(rec1[3], rec2[3]) - Math.max(rec1[1], rec2[1]);

        return xOverlap > 0 && yOverlap > 0;
    }
}
