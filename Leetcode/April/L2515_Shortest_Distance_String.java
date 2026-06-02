package Leetcode.April;

public class L2515_Shortest_Distance_String {
    public static void main(String[] args) {
        String[] words = {"hello","i","am","leetcode","hello"};
        String target = "hello";
        int startIndex = 1;
        System.out.println(closestTarget(words, target, startIndex));
    }

//    public static int closestTarget(String[] words, String target, int startIndex) {
//        int rightDis = 0, leftDis = 0;
//
//        for (int i = startIndex; i < words.length; i++) {
//            if (words[i].equals(target)) {
//                rightDis = Math.min(startIndex, rightDis - startIndex);
//            }
//        }
//        for (int j = startIndex; j > -1; j--) {
//            if (words[j].equals(target)) {
//                leftDis = Math.min(startIndex, leftDis - startIndex);
//        }
//        return Math.min(rightDis, leftDis);
//    }

    public static int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                // Calculate absolute difference
                int absDist = Math.abs(i - startIndex);

                // Compare direct distance vs. wrapping around the circle
                int currentDist = Math.min(absDist, n - absDist);

                // Update the global minimum
                minDistance = Math.min(minDistance, currentDist);
            }
        }

        // If minDistance was never updated, the target wasn't found
        return (minDistance == Integer.MAX_VALUE) ? -1 : minDistance;
    }
}
