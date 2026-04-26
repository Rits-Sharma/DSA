package Leetcode;

public class L2078_Two_Furthest_Houses {
    public static void main(String[] args) {
        int[] colors = {4,4,4,11,4,4,11,4,4,4,4,4};
        System.out.println(maxDistance(colors));
    }

    public static int maxDistance(int[] colors) {
        int n = colors.length;
        int left = 0, right = n-1, leftDis = 0, rightDis = 0;
        int i = 0, j = n-1;
        while (i < n) {
            if (colors[i] != colors[left]) leftDis = i;
            i++;
        }
        while (j >= 0) {
            if (colors[j] != colors[right]) rightDis = j;
            j--;
        }
        System.out.println(n);
        System.out.println();
        System.out.println(leftDis + " " + rightDis);
        return Math.max(leftDis - left, right - rightDis);
    }
}
