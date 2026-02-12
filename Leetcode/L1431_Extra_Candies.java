package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class L1431_Extra_Candies {
    public static void main(String[] args) {
        int[] candies = {2,3,5,1,3};
        int extraCandies = 3;
        L1431_Extra_Candies obj = new L1431_Extra_Candies();
        System.out.println(obj.kidsWithCandies(candies, extraCandies));
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        int greatest = 0;
        for (int curr : candies) {
            if (greatest < curr) greatest = curr;
        }
        for (int candy : candies) {
            if ((candy + extraCandies) >= greatest) list.add(true);
            else list.add(false);
        }
        return list;
    }
}
