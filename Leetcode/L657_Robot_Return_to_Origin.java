package Leetcode;

public class L657_Robot_Return_to_Origin {
    public static void main(String[] args) {
        L657_Robot_Return_to_Origin lr = new L657_Robot_Return_to_Origin();
        String moves = "RULD";
        System.out.println(lr.judgeCircle(moves));
    }

    public boolean judgeCircle(String moves) {
        int x_start = 0, y_start = 0, x = 0, y = 0;
        int[] movePos = {x, y};
        char[] movement = moves.toCharArray();
        for (char c : movement) {
            movePos = validMoves(new int[]{movePos[0], movePos[1]}, c);
        }
        return movePos[0] == x_start && movePos[1] == y_start;
    }

    private int[] validMoves(int[] pos, char movement) {
        if(movement == 'L') pos[0] -= 1;
        else if (movement == 'R') pos[0] += 1;
        else if (movement == 'U') pos[1] += 1;
        else if (movement == 'D') pos[1] -= 1;
        return pos;
    }
}
