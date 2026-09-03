package Leetcode.July;

public class L1464_Maximum_Product_of_Two_Elements_in_an_Array {
    public static void main(String[] args) {
        int[] nums = {1,4,5,3};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        int max1 = 0;
        int max2 = 0;

        for (int n : nums) {
            if (n > max1) {
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max2 = n;
            }
        }

        return (max1 - 1) * (max2 - 1);
    }
}
