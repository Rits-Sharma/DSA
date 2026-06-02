package Leetcode.April;

import java.util.*;

public class L2751_Robot_Collisions {
    public static void main(String[] args) {
//        int[] positions = {1,2,3,4,5};
//        int[] healths = {10,5,7,12,18};
//        String directions = "RLLRL";
        int[] positions = {3,5,2,6};
        int[] healths = {10,10,15,12};
        String directions = "RLRL";
        System.out.println(survivedRobotsHealths(positions, healths, directions));
    }

    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        Robot[] robots = new Robot[positions.length];
        for (int i = 0; i < positions.length; i++){
            int x = positions[i];
            int y = healths[i];
            char c = directions.charAt(i);
            Robot r = new Robot(x,y,c,i);
            robots[i] = r;
        }
//        System.out.println(Arrays.toString(robots));
        Stack<Robot> stack = new Stack<>();
        Arrays.sort(robots, (a,b) -> a.position - b.position);
//        System.out.println(Arrays.toString(robots));
        for(Robot curr : robots){
            if(curr.direction == 'L'){
                if(!stack.isEmpty()){
//                    collision
                    Robot topRobot = stack.peek();

                    // condition 1 topRobot.hp > curr.hp
                    if(topRobot.health > curr.health){
                        topRobot.health -= 1;
                    }
                    // condition 2 topRobot.hp < curr.hp
                    else if (topRobot.health < curr.health) {
                        boolean isMyCurrDestroyed = false;
                        while (!stack.empty()){
                            if(stack.peek().health > curr.health){
                                stack.peek().health -= 1;
                                isMyCurrDestroyed = true;
                                break;
                            }
                            else if(stack.peek().health < curr.health){
                                stack.pop();
                                curr.health -= 1;
                            } else {
                                stack.pop();
                                isMyCurrDestroyed = true;
                                break;
                            }
                        }
                        if(!isMyCurrDestroyed){
                            stack.push(curr);
                        }

                    }
                    // condition 3 topRObot.hp == curr.hp
                    else {
                        stack.pop();
                    }
                } else {
                    stack.push(curr);
                }
            }
            else {
                stack.push(curr);
            }
        }
        List<Robot> survivedRobots = new ArrayList<>();
        while (!stack.isEmpty()){
            survivedRobots.add(stack.pop());
        }
        survivedRobots.sort((a,b) -> a.input_position - b.input_position);
        List<Integer> res = new ArrayList<>();
        for(Robot curr : survivedRobots){
            res.add(curr.health);
        }
        return res;
    }
}

class Robot{
    int position;
    int health;
    char direction;
    int input_position;
    public Robot(int position, int health, char direction, int input_position) {
        this.position = position;
        this.health = health;
        this.direction = direction;
        this.input_position = input_position;
    }


}