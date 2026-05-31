package Leetcode;

import java.util.Arrays;

public class L1861_Rotating_the_Box {
    public static void main(String[] args) {
        char[][] boxGrid = {{'#','.','*','.'},{'#','#','*','.'}};
        char[][] ans = rotateTheBox(boxGrid);
        for (char[] an : ans) {
            for (char c : an) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static char[][] rotateTheBox(char[][] boxGrid) {
//   stone-> '#', stationary obstacle->'*', Empty->'.'
        int m = boxGrid.length;             // rows for grid,
        int n = boxGrid[0].length;          // cols for grid,
        System.out.println("rows for ans : " + n + ", columns for ans : " + m);

        char[][] ans = new char[n][m];
        for (char[] r : ans) {
            Arrays.fill(r, '.');
        }

        for(int i=0; i<m; i++) {
            int last = n-1;
            for(int j=n-1; j>=0; j--) {
                if(boxGrid[i][j]=='*') {
                    ans[j][m-1-i] = '*';
                    last = j-1;
                } else if(boxGrid[i][j]=='#') {
                    ans[last][m-1-i] = '#';
                    last--;
                }
            }
        }
        return ans;
    }
}
