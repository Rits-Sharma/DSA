package Leetcode.June;

public class L1344_Angle_Between_Hands_of_Clock {
    public static void main(String[] args) {
        int hour = 12, minutes = 30;
        System.out.println(angleClock(hour, minutes));
    }

    public static double angleClock(int hour, int minutes) {
        double hourDegree = (hour % 12) * 30 + (0.5) * minutes;
        double minuteDegree = 6 * minutes;

        double angle = Math.abs(hourDegree - minuteDegree);

        return Math.min(angle, 360 - angle);
    }
}
