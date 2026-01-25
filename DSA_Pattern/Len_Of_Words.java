package DSA_Pattern;

import java.util.ArrayList;

public class Len_Of_Words {
    public static void main(String[] args) {
        char[][] grid = { {'c', 'a', 't', ' ', 'a', 't'},
                          {'p', 'u', 'z', 'z', 'l', 'e'},
                          {'g', 'o', ' ', 'h', 'a', 't'} };
        int[] num = countStats(grid);
        System.out.println("Min: " + num[0] + " Max: " + num[1] + " Difference: " + num[2]);
    }

    public static int[] countStats(char[][] grid) {
        ArrayList<Integer> wordLength = new ArrayList<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, diff = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int row = 0; row < rows; row++) {
            int len = 0;
            for (int col = 0; col < cols; col++) {
                if(grid[row][col] != ' ') len++;
                else {
                    wordLength.add(len);
                    min = Integer.min(min, len);
                    max = Integer.max(max, len);
                    len = 0;
                }
            }
            if(len > 0) {
                wordLength.add(len);
                min = Integer.min(min, len);
                max = Integer.max(max, len);
            }
        }
        for (int i = 0; i < wordLength.toArray().length; i++) {
            System.out.print(wordLength.get(i) + " ");
            diff += (max - wordLength.get(i));
        }
        return new int[]{min, max, diff};
    }
}
