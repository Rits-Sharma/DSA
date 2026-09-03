package Leetcode.August;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L1386_Cinema_Seat_Allocation {
    public static void main(String[] args) {
        int n = 3;
        int[][] seats = {{1,2}, {1,3},{1,8}, {2,6}, {3,1}, {3,10}};
        System.out.println(maxNumberOfFamilies(n, seats));
    }

    public static int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            if (col >= 2 && col <= 9) {
                map.computeIfAbsent(row, k -> new HashSet<>()).add(col);
            }
        }

        int result = (n - map.size()) * 2;

        for (Set<Integer> seats : map.values()) {
            boolean left = true;
            boolean middle = true;
            boolean right = true;

            for (int seat = 2; seat <= 5; seat++) {
                if (seats.contains(seat)) {
                    left = false;
                    break;
                }
            }

            for (int seat = 4; seat <= 7; seat++) {
                if (seats.contains(seat)) {
                    middle = false;
                    break;
                }
            }

            for (int seat = 6; seat <= 9; seat++) {
                if (seats.contains(seat)) {
                    right = false;
                    break;
                }
            }

            if (left && right) {
                result += 2;
            } else if (left || middle || right) {
                result++;
            }
        }

        return result;
    }
}
