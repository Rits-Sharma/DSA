package Leetcode.April;

import java.util.HashSet;
import java.util.Set;

public class L874_Walking_Robot_Simulation {
    public static void main(String[] args) {
        int[] commands = {4,-1,4,-2,4};
        int[][] obstacles = {};
        System.out.println(robotSim(commands, obstacles));
    }

    public static int robotSim(int[] commands, int[][] obstacles) {
        // Directions: North, East, South, West
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        int x = 0, y = 0;
        int d = 0; // facing North

        // Store obstacles in a HashSet
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obs : obstacles) {
            obstacleSet.add(obs[0] + "," + obs[1]);
        }

        int maxDist = 0;

        for (int cmd : commands) {
            if (cmd == -2) {
                d = (d + 3) % 4; // turn left
            } else if (cmd == -1) {
                d = (d + 1) % 4; // turn right
            } else {
                int dx = dirs[d][0];
                int dy = dirs[d][1];

                for (int i = 0; i < cmd; i++) {
                    int nx = x + dx;
                    int ny = y + dy;

                    if (obstacleSet.contains(nx + "," + ny)) {
                        break;
                    }

                    x = nx;
                    y = ny;

                    maxDist = Math.max(maxDist, x*x + y*y);
                }
            }
        }
        return maxDist;
    }
}
