package Striver_DSA_Sheet.Binary_Search;

public class L875_Koko_Eating_Bananas {
    public static void main(String[] args) {
        int[] piles = {30,11,23,4,20};
        int h = 5;
        System.out.println(minEatingSpeed(piles, h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int ele : piles) {
            if (ele > max) max = ele;
        }

        int left = 1, right = max;
        while (left < right) {
            int mid = left + (right - left) / 2;
            long total = 0;
            for (int pile : piles) {
                total += (int) Math.ceil((double) pile / mid);
            }
            if (total <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
