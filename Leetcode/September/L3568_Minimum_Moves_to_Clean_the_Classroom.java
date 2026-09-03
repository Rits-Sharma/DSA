package Leetcode.September;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class L3568_Minimum_Moves_to_Clean_the_Classroom {
    public static void main(String[] args) {
        String[] classroom = {"S.", "XL"};
        int energy = 3;
        System.out.println(minMoves(classroom, energy));
    }

    static class State {
        int r,c;
        int energy, mask, moves;

        State(int r, int c, int energy, int mask, int moves) {
            this.r = r;
            this.c = c;
            this.energy = energy;
            this.mask = mask;
            this.moves = moves;
        }
    }

    public static int minMoves(String[] classroom, int energy) {
        int m =  classroom.length;
        int n = classroom[0].length();

        int sr = 0, sc = 0;
        int litterCount = 0;

        int[][] litterId =  new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(litterId[i], -1);
            for (int j = 0; j < n; j++) {
                if (classroom[i].charAt(j) == 'S') {
                    sr = i;
                    sc = j;
                }
                if (classroom[i].charAt(j) == 'L') {
                    litterId[i][j] = litterCount;
                    litterCount++;
                }
            }
        }

        int target = (1 << litterCount) - 1;

        Queue<State> q = new LinkedList<>();
        q.offer(new State(sr, sc, energy, 0, 0));

        boolean[][][][] visited = new boolean[m][n][energy + 1][1 << litterCount];
        visited[sr][sc][energy][0] = true;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        while (!q.isEmpty()) {
            State cur = q.poll();
            if (cur.mask == target) return cur.moves;

            for (int d = 0; d < 4; d++) { // TRYING ALL 4 DIRECTIONS
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                if (classroom[nr].charAt(nc) == 'X') continue;
                if (cur.energy == 0) continue;

                int newEnergy = cur.energy - 1;

                if (classroom[nr].charAt(nc) == 'R') newEnergy = energy;

                int newMask = cur.mask;
                int id = litterId[nr][nc];

                if (id != -1) newMask |= (1 << id);
                if (visited[nr][nc][newEnergy][newMask]) continue;
                visited[nr][nc][newEnergy][newMask] = true;
                q.offer(new State(nr, nc, newEnergy, newMask, cur.moves + 1));
            }
        }
        return -1;
    }
}
