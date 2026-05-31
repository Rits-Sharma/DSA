package Leetcode;

import java.util.Arrays;

public class L2126_Destroying_Asteroids {
    public static void main(String[] args) {
        int mass = 86;
        int[] asteroids = {156,197,192,14,97,160,14,5};
        System.out.println(asteroidsDestroyed(mass, asteroids));
    }

    public static boolean asteroidsDestroyed(int mass, int[] asteroids) {
        int planetMass = mass;

        Arrays.sort(asteroids);

        for (int i = 0; i < asteroids.length; i++) {
            if (planetMass >= asteroids[i]) {
                planetMass += asteroids[i];
                asteroids[i] = 0;
            }
        }
        for (int ele : asteroids) {
            if (ele != 0) return false;
        }
        return true;
    }
}
